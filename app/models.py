from pydantic import BaseModel, EmailStr, field_validator
from typing import Optional, List
from datetime import datetime


# --- Product Models ---

class CreateProductRequest(BaseModel):
    name: str
    description: str
    price: float
    category: str

class UpdateProductRequest(BaseModel):
    name: Optional[str] = None
    description: Optional[str] = None
    price: Optional[float] = None
    category: Optional[str] = None

class ProductResponse(BaseModel):
    id: str
    name: str
    description: str
    price: float
    category: str
    averageRating: float
    reviewCount: int
    createdAt: Optional[datetime] = None
    updatedAt: Optional[datetime] = None

class ProductListResponse(BaseModel):
    data: List[ProductResponse]
    total: int
    page: int
    limit: int


# --- Review Models ---

class CreateReviewRequest(BaseModel):
    rating: int
    title: str
    body: str
    userId: str

    @field_validator("rating")
    @classmethod
    def rating_must_be_valid(cls, v):
        if not 1 <= v <= 5:
            raise ValueError("rating must be between 1 and 5")
        return v

class ReviewResponse(BaseModel):
    id: str
    productId: str
    userId: str
    userName: str
    rating: int
    title: str
    body: str
    createdAt: datetime

class ReviewListResponse(BaseModel):
    data: List[ReviewResponse]
    total: int
    page: int
    limit: int


# --- User Models ---

class RegisterUserRequest(BaseModel):
    name: str
    email: str
    password: str

class LoginRequest(BaseModel):
    email: str
    password: str

class UserResponse(BaseModel):
    id: str
    name: str
    email: str
    reviewCount: int
    createdAt: datetime

class LoginResponse(BaseModel):
    token: str
    user: dict


# --- Error Models ---

class ErrorResponse(BaseModel):
    error: str

class ValidationErrorResponse(BaseModel):
    error: str
    details: List[str]
