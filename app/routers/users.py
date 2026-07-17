from fastapi import APIRouter, HTTPException
from uuid import uuid4
from jose import jwt
from passlib.context import CryptContext
from app.models import RegisterUserRequest, LoginRequest, UserResponse, LoginResponse
from app import store

router = APIRouter(prefix="/users", tags=["Users"])

pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")
SECRET_KEY = "change-me-in-production"
ALGORITHM = "HS256"


@router.post("/register", response_model=UserResponse, status_code=201)
def register(body: RegisterUserRequest):
    if body.email in store.users_by_email:
        raise HTTPException(status_code=409, detail="Email already in use")
    user_id = f"usr_{uuid4().hex[:8]}"
    hashed_pw = pwd_context.hash(body.password)
    user = {
        "id": user_id,
        "name": body.name,
        "email": body.email,
        "password": hashed_pw,
        "createdAt": store.now(),
    }
    store.users[user_id] = user
    store.users_by_email[body.email] = user_id
    review_count = len([r for r in store.reviews.values() if r["userId"] == user_id])
    return UserResponse(
        id=user_id,
        name=user["name"],
        email=user["email"],
        reviewCount=review_count,
        createdAt=user["createdAt"],
    )


@router.post("/login", response_model=LoginResponse)
def login(body: LoginRequest):
    user_id = store.users_by_email.get(body.email)
    if not user_id:
        raise HTTPException(status_code=401, detail="Invalid email or password")
    user = store.users[user_id]
    if not pwd_context.verify(body.password, user["password"]):
        raise HTTPException(status_code=401, detail="Invalid email or password")
    token = jwt.encode({"sub": user_id, "email": user["email"]}, SECRET_KEY, algorithm=ALGORITHM)
    return LoginResponse(
        token=token,
        user={"id": user["id"], "name": user["name"], "email": user["email"]},
    )


@router.get("/{userId}", response_model=UserResponse)
def get_user_profile(userId: str):
    user = store.users.get(userId)
    if not user:
        raise HTTPException(status_code=404, detail="User not found")
    review_count = len([r for r in store.reviews.values() if r["userId"] == userId])
    return UserResponse(
        id=user["id"],
        name=user["name"],
        email=user["email"],
        reviewCount=review_count,
        createdAt=user["createdAt"],
    )
