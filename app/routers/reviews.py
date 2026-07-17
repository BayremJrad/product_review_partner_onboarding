from fastapi import APIRouter, HTTPException, Query
from uuid import uuid4
from app.models import CreateReviewRequest, ReviewResponse, ReviewListResponse
from app import store

router = APIRouter(prefix="/products/{productId}/reviews", tags=["Reviews"])


@router.get("", response_model=ReviewListResponse)
def list_reviews(productId: str, page: int = Query(1, ge=1), limit: int = Query(20, ge=1, le=100)):
    if productId not in store.products:
        raise HTTPException(status_code=404, detail="Product not found")
    product_reviews = [r for r in store.reviews.values() if r["productId"] == productId]
    total = len(product_reviews)
    start = (page - 1) * limit
    end = start + limit
    paginated = product_reviews[start:end]
    return ReviewListResponse(
        data=[ReviewResponse(**r) for r in paginated],
        total=total,
        page=page,
        limit=limit,
    )


@router.post("", response_model=ReviewResponse, status_code=201)
def create_review(productId: str, body: CreateReviewRequest):
    if productId not in store.products:
        raise HTTPException(status_code=404, detail="Product not found")
    user = store.users.get(body.userId)
    user_name = user["name"] if user else "Anonymous"
    review_id = f"rev_{uuid4().hex[:8]}"
    review = {
        "id": review_id,
        "productId": productId,
        "userId": body.userId,
        "userName": user_name,
        "rating": body.rating,
        "title": body.title,
        "body": body.body,
        "createdAt": store.now(),
    }
    store.reviews[review_id] = review
    return ReviewResponse(**review)


@router.get("/{reviewId}", response_model=ReviewResponse)
def get_review(productId: str, reviewId: str):
    review = store.reviews.get(reviewId)
    if not review or review["productId"] != productId:
        raise HTTPException(status_code=404, detail="Review not found")
    return ReviewResponse(**review)


@router.delete("/{reviewId}", status_code=204)
def delete_review(productId: str, reviewId: str):
    review = store.reviews.get(reviewId)
    if not review or review["productId"] != productId:
        raise HTTPException(status_code=404, detail="Review not found")
    del store.reviews[reviewId]
