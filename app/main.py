from fastapi import FastAPI, Request
from fastapi.responses import JSONResponse
from pydantic import ValidationError
from app.routers import products, reviews, users

app = FastAPI(
    title="Product Review API",
    version="1.0.0",
    description="API for managing products and their reviews.",
)

app.include_router(products.router)
app.include_router(reviews.router)
app.include_router(users.router)


@app.exception_handler(ValidationError)
async def validation_exception_handler(request: Request, exc: ValidationError):
    details = [f"{e['loc'][-1]}: {e['msg']}" for e in exc.errors()]
    return JSONResponse(
        status_code=400,
        content={"error": "Validation failed", "details": details},
    )


@app.get("/", include_in_schema=False)
def root():
    return {"message": "Product Review API is running. Visit /docs for the interactive API docs."}
