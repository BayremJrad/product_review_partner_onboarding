# ProductReviewApiSdk Java SDK 1.0.0

Welcome to the ProductReviewApiSdk SDK documentation. This guide will help you get started with integrating and using the ProductReviewApiSdk SDK in your project.

## Versions

- SDK version: `1.0.0`

## Table of Contents

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Java >= 1.8`

## Installation

If you use Maven, place the following within the _dependency_ tag in your `pom.xml` file:

```XML
<dependency>
    <groupId>com</groupId>
    <artifactId>productreviewapisdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

If you use Gradle, paste the next line inside the _dependencies_ block of your `build.gradle` file:

```Gradle
implementation("com:productreviewapisdk:1.0.0")
```

If you use JAR files, package the SDK by running the following command:

```shell
mvn compile assembly:single
```

Then, add the JAR file to your project's classpath.

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.config.ProductReviewApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdkConfig config = ProductReviewApiSdkConfig.builder().timeout(10000).build();
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk(config);
  }
}

```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```java
import com.productreviewapisdk.ProductReviewApiSdk;
import com.productreviewapisdk.exceptions.ApiError;

public class Main {

  public static void main(String[] args) {
    ProductReviewApiSdk productReviewApiSdk = new ProductReviewApiSdk();

    try {
      Object response = productReviewApiSdk.productReviewApiSdk.listProducts();

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}

```

## Services

The SDK provides various services to interact with the API.

<details>
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                                                               |
| :--------------------------------------------------------------------------------- |
| [ProductReviewApiSdkService](documentation/services/ProductReviewApiSdkService.md) |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details>
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                                 | Description |
| :------------------------------------------------------------------- | :---------- |
| [CreateProductRequest](documentation/models/CreateProductRequest.md) |             |
| [UpdateProductRequest](documentation/models/UpdateProductRequest.md) |             |
| [CreateReviewRequest](documentation/models/CreateReviewRequest.md)   |             |
| [RegisterUserRequest](documentation/models/RegisterUserRequest.md)   |             |
| [LoginRequest](documentation/models/LoginRequest.md)                 |             |

</details>
