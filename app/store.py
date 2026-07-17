from datetime import datetime, timezone
from typing import Dict, Any

# In-memory stores
products: Dict[str, Any] = {}
reviews: Dict[str, Any] = {}   # key: reviewId, value includes productId
users: Dict[str, Any] = {}     # key: userId
users_by_email: Dict[str, str] = {}  # email -> userId


def compute_product_rating(product_id: str):
    product_reviews = [r for r in reviews.values() if r["productId"] == product_id]
    count = len(product_reviews)
    if count == 0:
        return 0.0, 0
    avg = sum(r["rating"] for r in product_reviews) / count
    return round(avg, 1), count


def now() -> datetime:
    return datetime.now(timezone.utc)
