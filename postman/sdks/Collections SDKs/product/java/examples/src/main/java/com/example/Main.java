package com.example;

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
