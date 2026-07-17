package com.productreviewapisdk;

import com.productreviewapisdk.config.ProductReviewApiSdkConfig;
import com.productreviewapisdk.http.Environment;
import com.productreviewapisdk.http.interceptors.DefaultHeadersInterceptor;
import com.productreviewapisdk.http.interceptors.RetryInterceptor;
import com.productreviewapisdk.services.ProductReviewApiSdkService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * Main SDK client class for ProductReviewApiSdk.
 * Provides centralized access to all service endpoints with configurable authentication,
 * environment management, hooks, and HTTP client settings.
 */
public class ProductReviewApiSdk {

  public final ProductReviewApiSdkService productReviewApiSdk;

  private final ProductReviewApiSdkConfig config;

  /**
   * Constructs a new instance of ProductReviewApiSdk with default configuration.
   */
  public ProductReviewApiSdk() {
    // Default configs
    this(ProductReviewApiSdkConfig.builder().build());
  }

  /**
   * Constructs a new instance of ProductReviewApiSdk with custom configuration.
   * Initializes all services, HTTP client, and optional OAuth token manager.
   *
   * @param config The SDK configuration including base URL, authentication, timeout, and retry settings
   */
  public ProductReviewApiSdk(ProductReviewApiSdkConfig config) {
    this.config = config;

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.productReviewApiSdk = new ProductReviewApiSdkService(httpClient, config);
  }

  /**
   * Sets the environment for all API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for all API requests.
   *
   * @param baseUrl The base URL to use for API requests
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
