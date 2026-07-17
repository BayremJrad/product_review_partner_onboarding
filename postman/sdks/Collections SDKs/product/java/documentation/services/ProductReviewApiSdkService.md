# ProductReviewApiSdkService

A list of all methods in the `ProductReviewApiSdkService` service. Click on the method name to view detailed information about that method.

| Methods                           | Description |
| :-------------------------------- | :---------- |
| [listProducts](#listproducts)     |             |
| [createProduct](#createproduct)   |             |
| [getProduct](#getproduct)         |             |
| [updateProduct](#updateproduct)   |             |
| [deleteProduct](#deleteproduct)   |             |
| [listReviews](#listreviews)       |             |
| [createReview](#createreview)     |             |
| [getReview](#getreview)           |             |
| [deleteReview](#deletereview)     |             |
| [registerUser](#registeruser)     |             |
| [login](#login)                   |             |
| [getUserProfile](#getuserprofile) |             |

## listProducts

- HTTP Method: `GET`
- Endpoint: `/products`

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    Object response = productReviewApiSdk.productReviewApiSdk.listProducts();

    System.out.println(response);
  }
}

```

## createProduct

- HTTP Method: `POST`
- Endpoint: `/products`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| createProductRequest | [CreateProductRequest](../models/CreateProductRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.models.CreateProductRequest;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    CreateProductRequest createProductRequest = CreateProductRequest.builder()
      .name("Wireless Headphones")
      .description("Over-ear noise cancelling headphones")
      .price(79.99D)
      .category("Electronics")
      .build();

    Object response = productReviewApiSdk.productReviewApiSdk.createProduct(createProductRequest);

    System.out.println(response);
  }
}

```

## getProduct

- HTTP Method: `GET`
- Endpoint: `/products/{productId}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| productId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    Object response = productReviewApiSdk.productReviewApiSdk.getProduct("productId");

    System.out.println(response);
  }
}

```

## updateProduct

- HTTP Method: `PUT`
- Endpoint: `/products/{productId}`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| productId            | String                                                    | ✅       |              |
| updateProductRequest | [UpdateProductRequest](../models/UpdateProductRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.models.UpdateProductRequest;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    UpdateProductRequest updateProductRequest = UpdateProductRequest.builder()
      .name("Wireless Headphones Pro")
      .price(89.99D)
      .build();

    Object response = productReviewApiSdk.productReviewApiSdk.updateProduct(
      "productId",
      updateProductRequest
    );

    System.out.println(response);
  }
}

```

## deleteProduct

- HTTP Method: `DELETE`
- Endpoint: `/products/{productId}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| productId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    Object response = productReviewApiSdk.productReviewApiSdk.deleteProduct("productId");

    System.out.println(response);
  }
}

```

## listReviews

- HTTP Method: `GET`
- Endpoint: `/products/{productId}/reviews`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| productId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    Object response = productReviewApiSdk.productReviewApiSdk.listReviews("productId");

    System.out.println(response);
  }
}

```

## createReview

- HTTP Method: `POST`
- Endpoint: `/products/{productId}/reviews`

**Parameters**

| Name                | Type                                                    | Required | Description  |
| :------------------ | :------------------------------------------------------ | :------- | :----------- |
| productId           | String                                                  | ✅       |              |
| createReviewRequest | [CreateReviewRequest](../models/CreateReviewRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.models.CreateReviewRequest;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    CreateReviewRequest createReviewRequest = CreateReviewRequest.builder()
      .rating(5D)
      .title("Great product!")
      .body("Really happy with this purchase. Sound quality is excellent.")
      .userId("usr_123")
      .build();

    Object response = productReviewApiSdk.productReviewApiSdk.createReview(
      "productId",
      createReviewRequest
    );

    System.out.println(response);
  }
}

```

## getReview

- HTTP Method: `GET`
- Endpoint: `/products/{productId}/reviews/{reviewId}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| productId | String | ✅       |             |
| reviewId  | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    Object response = productReviewApiSdk.productReviewApiSdk.getReview("productId", "reviewId");

    System.out.println(response);
  }
}

```

## deleteReview

- HTTP Method: `DELETE`
- Endpoint: `/products/{productId}/reviews/{reviewId}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| productId | String | ✅       |             |
| reviewId  | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    Object response = productReviewApiSdk.productReviewApiSdk.deleteReview("productId", "reviewId");

    System.out.println(response);
  }
}

```

## registerUser

- HTTP Method: `POST`
- Endpoint: `/users/register`

**Parameters**

| Name                | Type                                                    | Required | Description  |
| :------------------ | :------------------------------------------------------ | :------- | :----------- |
| registerUserRequest | [RegisterUserRequest](../models/RegisterUserRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.models.RegisterUserRequest;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    RegisterUserRequest registerUserRequest = RegisterUserRequest.builder()
      .name("Jane Doe")
      .email("jane@example.com")
      .password("securepassword123")
      .build();

    Object response = productReviewApiSdk.productReviewApiSdk.registerUser(registerUserRequest);

    System.out.println(response);
  }
}

```

## login

- HTTP Method: `POST`
- Endpoint: `/users/login`

**Parameters**

| Name         | Type                                      | Required | Description  |
| :----------- | :---------------------------------------- | :------- | :----------- |
| loginRequest | [LoginRequest](../models/LoginRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.models.LoginRequest;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    LoginRequest loginRequest = LoginRequest.builder()
      .email("jane@example.com")
      .password("securepassword123")
      .build();

    Object response = productReviewApiSdk.productReviewApiSdk.login(loginRequest);

    System.out.println(response);
  }
}

```

## getUserProfile

- HTTP Method: `GET`
- Endpoint: `/users/{userId}`

**Parameters**

| Name   | Type   | Required | Description |
| :----- | :----- | :------- | :---------- |
| userId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.productreviewapisdk.ProductReviewApiSdk;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    Object response = productReviewApiSdk.productReviewApiSdk.getUserProfile("userId");

    System.out.println(response);
  }
}

```
