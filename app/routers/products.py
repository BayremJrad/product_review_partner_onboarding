from fastapi import APIRouter, HTTPException, Query
from uuid import uuid4
from app.models import (
    CreateProductRequest, UpdateProductRequest,
    ProductResponse, ProductListResponse
)
from app import store

router = APIRouter(prefix="/products", tags=["Products"])


def _build_product_response(p: dict) -> ProductResponse:
    avg, count = store.compute_product_rating(p["id"])
    return ProductResponse(
        id=p["id"],
        name=p["name"],
        description=p["description"],
        price=p["price"],
        category=p["category"],
        averageRating=avg,
        reviewCount=count,
        createdAt=p.get("createdAt"),
        updatedAt=p.get("updatedAt"),
    )


@router.get("", response_model=ProductListResponse)
def list_products(page: int = Query(1, ge=1), limit: int = Query(20, ge=1, le=100)):
    all_products = list(store.products.values())
    total = len(all_products)
    start = (page - 1) * limit
    end = start + limit
    paginated = all_products[start:end]
    return ProductListResponse(
        data=[_build_product_response(p) for p in paginated],
        total=total,
        page=page,
        limit=limit,
    )


@router.post("", response_model=ProductResponse, status_code=201)
def create_product(body: CreateProductRequest):
    product_id = f"prod_{uuid4().hex[:8]}"
    product = {
        "id": product_id,
        "name": body.name,
        "description": body.description,
        "price": body.price,
        "category": body.category,
        "createdAt": store.now(),
    }
    store.products[product_id] = product
    return _build_product_response(product)


@router.get("/{productId}", response_model=ProductResponse)
def get_product(productId: str):
    product = store.products.get(productId)
    if not product:
        raise HTTPException(status_code=404, detail="Product not found")
    return _build_product_response(product)


@router.put("/{productId}", response_model=ProductResponse)
def update_product(productId: str, body: UpdateProductRequest):
    product = store.products.get(productId)
    if not product:
        raise HTTPException(status_code=404, detail="Product not found")
    if body.name is not None:
        product["name"] = body.name
    if body.description is not None:
        product["description"] = body.description
    if body.price is not None:
        product["price"] = body.price
    if body.category is not None:
        product["category"] = body.category
    product["updatedAt"] = store.now()
    return _build_product_response(product)


@router.delete("/{productId}", status_code=204)
def delete_product(productId: str):
    if productId not in store.products:
        raise HTTPException(status_code=404, detail="Product not found")
    del store.products[productId]
    # Also remove associated reviews
    to_delete = [rid for rid, r in store.reviews.items() if r["productId"] == productId]
    for rid in to_delete:
        del store.reviews[rid]
