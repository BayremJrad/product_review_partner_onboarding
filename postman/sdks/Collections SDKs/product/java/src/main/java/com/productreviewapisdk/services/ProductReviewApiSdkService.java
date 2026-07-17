package com.productreviewapisdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.productreviewapisdk.config.ProductReviewApiSdkConfig;
import com.productreviewapisdk.config.RequestConfig;
import com.productreviewapisdk.exceptions.ApiError;
import com.productreviewapisdk.http.Environment;
import com.productreviewapisdk.http.HttpMethod;
import com.productreviewapisdk.http.ModelConverter;
import com.productreviewapisdk.http.util.RequestBuilder;
import com.productreviewapisdk.models.CreateProductRequest;
import com.productreviewapisdk.models.CreateReviewRequest;
import com.productreviewapisdk.models.LoginRequest;
import com.productreviewapisdk.models.RegisterUserRequest;
import com.productreviewapisdk.models.UpdateProductRequest;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ProductReviewApiSdkService Service
 */
public class ProductReviewApiSdkService extends BaseService {

  private RequestConfig listProductsConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig createProductConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig getProductConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig updateProductConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig deleteProductConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig listReviewsConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig createReviewConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig getReviewConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig deleteReviewConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig registerUserConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();
  private RequestConfig loginConfig = RequestConfig.builder().environment(Environment.API).build();
  private RequestConfig getUserProfileConfig = RequestConfig.builder()
    .environment(Environment.API)
    .build();

  /**
   * Constructs a new instance of ProductReviewApiSdkService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public ProductReviewApiSdkService(
    @NonNull OkHttpClient httpClient,
    ProductReviewApiSdkConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code listProducts}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setListProductsConfig(RequestConfig config) {
    this.listProductsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createProduct}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setCreateProductConfig(RequestConfig config) {
    this.createProductConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getProduct}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setGetProductConfig(RequestConfig config) {
    this.getProductConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code updateProduct}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setUpdateProductConfig(RequestConfig config) {
    this.updateProductConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteProduct}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setDeleteProductConfig(RequestConfig config) {
    this.deleteProductConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listReviews}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setListReviewsConfig(RequestConfig config) {
    this.listReviewsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createReview}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setCreateReviewConfig(RequestConfig config) {
    this.createReviewConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getReview}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setGetReviewConfig(RequestConfig config) {
    this.getReviewConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteReview}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setDeleteReviewConfig(RequestConfig config) {
    this.deleteReviewConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code registerUser}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setRegisterUserConfig(RequestConfig config) {
    this.registerUserConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code login}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setLoginConfig(RequestConfig config) {
    this.loginConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getUserProfile}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ProductReviewApiSdkService setGetUserProfileConfig(RequestConfig config) {
    this.getUserProfileConfig = config;
    return this;
  }

  /**
   * Method listProducts
   * GET /products
   *
   * @return response of {@code Object}
   */
  public Object listProducts() throws ApiError {
    return this.listProducts(null);
  }

  /**
   * Method listProducts
   * GET /products
   *
   * @return response of {@code Object}
   */
  public Object listProducts(RequestConfig requestConfig) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listProductsConfig, requestConfig);
    Request request = this.buildListProductsRequest(resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method listProducts
   * GET /products
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listProductsAsync() throws ApiError {
    return this.listProductsAsync(null);
  }

  /**
   * Method listProducts
   * GET /products
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listProductsAsync(RequestConfig requestConfig) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listProductsConfig, requestConfig);
    Request request = this.buildListProductsRequest(resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildListProductsRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "products"
    ).build();
  }

  /**
   * Method createProduct
   * POST /products
   *
   * @param createProductRequest {@link CreateProductRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createProduct(@NonNull CreateProductRequest createProductRequest) throws ApiError {
    return this.createProduct(createProductRequest, null);
  }

  /**
   * Method createProduct
   * POST /products
   *
   * @param createProductRequest {@link CreateProductRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createProduct(
    @NonNull CreateProductRequest createProductRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createProductConfig, requestConfig);
    Request request = this.buildCreateProductRequest(createProductRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method createProduct
   * POST /products
   *
   * @param createProductRequest {@link CreateProductRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createProductAsync(
    @NonNull CreateProductRequest createProductRequest
  ) throws ApiError {
    return this.createProductAsync(createProductRequest, null);
  }

  /**
   * Method createProduct
   * POST /products
   *
   * @param createProductRequest {@link CreateProductRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createProductAsync(
    @NonNull CreateProductRequest createProductRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createProductConfig, requestConfig);
    Request request = this.buildCreateProductRequest(createProductRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildCreateProductRequest(
    @NonNull CreateProductRequest createProductRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "products"
    )
      .setJsonContent(createProductRequest)
      .build();
  }

  /**
   * Method getProduct
   * GET /products/{productId}
   *
   * @param productId String
   * @return response of {@code Object}
   */
  public Object getProduct(@NonNull String productId) throws ApiError {
    return this.getProduct(productId, null);
  }

  /**
   * Method getProduct
   * GET /products/{productId}
   *
   * @param productId String
   * @return response of {@code Object}
   */
  public Object getProduct(@NonNull String productId, RequestConfig requestConfig) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getProductConfig, requestConfig);
    Request request = this.buildGetProductRequest(productId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method getProduct
   * GET /products/{productId}
   *
   * @param productId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getProductAsync(@NonNull String productId) throws ApiError {
    return this.getProductAsync(productId, null);
  }

  /**
   * Method getProduct
   * GET /products/{productId}
   *
   * @param productId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getProductAsync(
    @NonNull String productId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getProductConfig, requestConfig);
    Request request = this.buildGetProductRequest(productId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetProductRequest(@NonNull String productId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "products/{productId}"
    )
      .setPathParameter("productId", productId)
      .build();
  }

  /**
   * Method updateProduct
   * PUT /products/{productId}
   *
   * @param productId String
   * @param updateProductRequest {@link UpdateProductRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateProduct(
    @NonNull String productId,
    @NonNull UpdateProductRequest updateProductRequest
  ) throws ApiError {
    return this.updateProduct(productId, updateProductRequest, null);
  }

  /**
   * Method updateProduct
   * PUT /products/{productId}
   *
   * @param productId String
   * @param updateProductRequest {@link UpdateProductRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateProduct(
    @NonNull String productId,
    @NonNull UpdateProductRequest updateProductRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.updateProductConfig, requestConfig);
    Request request =
      this.buildUpdateProductRequest(productId, updateProductRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method updateProduct
   * PUT /products/{productId}
   *
   * @param productId String
   * @param updateProductRequest {@link UpdateProductRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateProductAsync(
    @NonNull String productId,
    @NonNull UpdateProductRequest updateProductRequest
  ) throws ApiError {
    return this.updateProductAsync(productId, updateProductRequest, null);
  }

  /**
   * Method updateProduct
   * PUT /products/{productId}
   *
   * @param productId String
   * @param updateProductRequest {@link UpdateProductRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateProductAsync(
    @NonNull String productId,
    @NonNull UpdateProductRequest updateProductRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.updateProductConfig, requestConfig);
    Request request =
      this.buildUpdateProductRequest(productId, updateProductRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildUpdateProductRequest(
    @NonNull String productId,
    @NonNull UpdateProductRequest updateProductRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "products/{productId}"
    )
      .setPathParameter("productId", productId)
      .setJsonContent(updateProductRequest)
      .build();
  }

  /**
   * Method deleteProduct
   * DELETE /products/{productId}
   *
   * @param productId String
   * @return response of {@code Object}
   */
  public Object deleteProduct(@NonNull String productId) throws ApiError {
    return this.deleteProduct(productId, null);
  }

  /**
   * Method deleteProduct
   * DELETE /products/{productId}
   *
   * @param productId String
   * @return response of {@code Object}
   */
  public Object deleteProduct(@NonNull String productId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteProductConfig, requestConfig);
    Request request = this.buildDeleteProductRequest(productId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method deleteProduct
   * DELETE /products/{productId}
   *
   * @param productId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteProductAsync(@NonNull String productId) throws ApiError {
    return this.deleteProductAsync(productId, null);
  }

  /**
   * Method deleteProduct
   * DELETE /products/{productId}
   *
   * @param productId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteProductAsync(
    @NonNull String productId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteProductConfig, requestConfig);
    Request request = this.buildDeleteProductRequest(productId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDeleteProductRequest(
    @NonNull String productId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "products/{productId}"
    )
      .setPathParameter("productId", productId)
      .build();
  }

  /**
   * Method listReviews
   * GET /products/{productId}/reviews
   *
   * @param productId String
   * @return response of {@code Object}
   */
  public Object listReviews(@NonNull String productId) throws ApiError {
    return this.listReviews(productId, null);
  }

  /**
   * Method listReviews
   * GET /products/{productId}/reviews
   *
   * @param productId String
   * @return response of {@code Object}
   */
  public Object listReviews(@NonNull String productId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listReviewsConfig, requestConfig);
    Request request = this.buildListReviewsRequest(productId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method listReviews
   * GET /products/{productId}/reviews
   *
   * @param productId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listReviewsAsync(@NonNull String productId) throws ApiError {
    return this.listReviewsAsync(productId, null);
  }

  /**
   * Method listReviews
   * GET /products/{productId}/reviews
   *
   * @param productId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listReviewsAsync(
    @NonNull String productId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.listReviewsConfig, requestConfig);
    Request request = this.buildListReviewsRequest(productId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildListReviewsRequest(@NonNull String productId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "products/{productId}/reviews"
    )
      .setPathParameter("productId", productId)
      .build();
  }

  /**
   * Method createReview
   * POST /products/{productId}/reviews
   *
   * @param productId String
   * @param createReviewRequest {@link CreateReviewRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createReview(
    @NonNull String productId,
    @NonNull CreateReviewRequest createReviewRequest
  ) throws ApiError {
    return this.createReview(productId, createReviewRequest, null);
  }

  /**
   * Method createReview
   * POST /products/{productId}/reviews
   *
   * @param productId String
   * @param createReviewRequest {@link CreateReviewRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createReview(
    @NonNull String productId,
    @NonNull CreateReviewRequest createReviewRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createReviewConfig, requestConfig);
    Request request = this.buildCreateReviewRequest(productId, createReviewRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method createReview
   * POST /products/{productId}/reviews
   *
   * @param productId String
   * @param createReviewRequest {@link CreateReviewRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createReviewAsync(
    @NonNull String productId,
    @NonNull CreateReviewRequest createReviewRequest
  ) throws ApiError {
    return this.createReviewAsync(productId, createReviewRequest, null);
  }

  /**
   * Method createReview
   * POST /products/{productId}/reviews
   *
   * @param productId String
   * @param createReviewRequest {@link CreateReviewRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createReviewAsync(
    @NonNull String productId,
    @NonNull CreateReviewRequest createReviewRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.createReviewConfig, requestConfig);
    Request request = this.buildCreateReviewRequest(productId, createReviewRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildCreateReviewRequest(
    @NonNull String productId,
    @NonNull CreateReviewRequest createReviewRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "products/{productId}/reviews"
    )
      .setPathParameter("productId", productId)
      .setJsonContent(createReviewRequest)
      .build();
  }

  /**
   * Method getReview
   * GET /products/{productId}/reviews/{reviewId}
   *
   * @param productId String
   * @param reviewId String
   * @return response of {@code Object}
   */
  public Object getReview(@NonNull String productId, @NonNull String reviewId) throws ApiError {
    return this.getReview(productId, reviewId, null);
  }

  /**
   * Method getReview
   * GET /products/{productId}/reviews/{reviewId}
   *
   * @param productId String
   * @param reviewId String
   * @return response of {@code Object}
   */
  public Object getReview(
    @NonNull String productId,
    @NonNull String reviewId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getReviewConfig, requestConfig);
    Request request = this.buildGetReviewRequest(productId, reviewId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method getReview
   * GET /products/{productId}/reviews/{reviewId}
   *
   * @param productId String
   * @param reviewId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getReviewAsync(
    @NonNull String productId,
    @NonNull String reviewId
  ) throws ApiError {
    return this.getReviewAsync(productId, reviewId, null);
  }

  /**
   * Method getReview
   * GET /products/{productId}/reviews/{reviewId}
   *
   * @param productId String
   * @param reviewId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getReviewAsync(
    @NonNull String productId,
    @NonNull String reviewId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getReviewConfig, requestConfig);
    Request request = this.buildGetReviewRequest(productId, reviewId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetReviewRequest(
    @NonNull String productId,
    @NonNull String reviewId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "products/{productId}/reviews/{reviewId}"
    )
      .setPathParameter("productId", productId)
      .setPathParameter("reviewId", reviewId)
      .build();
  }

  /**
   * Method deleteReview
   * DELETE /products/{productId}/reviews/{reviewId}
   *
   * @param productId String
   * @param reviewId String
   * @return response of {@code Object}
   */
  public Object deleteReview(@NonNull String productId, @NonNull String reviewId) throws ApiError {
    return this.deleteReview(productId, reviewId, null);
  }

  /**
   * Method deleteReview
   * DELETE /products/{productId}/reviews/{reviewId}
   *
   * @param productId String
   * @param reviewId String
   * @return response of {@code Object}
   */
  public Object deleteReview(
    @NonNull String productId,
    @NonNull String reviewId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteReviewConfig, requestConfig);
    Request request = this.buildDeleteReviewRequest(productId, reviewId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method deleteReview
   * DELETE /products/{productId}/reviews/{reviewId}
   *
   * @param productId String
   * @param reviewId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteReviewAsync(
    @NonNull String productId,
    @NonNull String reviewId
  ) throws ApiError {
    return this.deleteReviewAsync(productId, reviewId, null);
  }

  /**
   * Method deleteReview
   * DELETE /products/{productId}/reviews/{reviewId}
   *
   * @param productId String
   * @param reviewId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteReviewAsync(
    @NonNull String productId,
    @NonNull String reviewId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.deleteReviewConfig, requestConfig);
    Request request = this.buildDeleteReviewRequest(productId, reviewId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildDeleteReviewRequest(
    @NonNull String productId,
    @NonNull String reviewId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "products/{productId}/reviews/{reviewId}"
    )
      .setPathParameter("productId", productId)
      .setPathParameter("reviewId", reviewId)
      .build();
  }

  /**
   * Method registerUser
   * POST /users/register
   *
   * @param registerUserRequest {@link RegisterUserRequest} Request Body
   * @return response of {@code Object}
   */
  public Object registerUser(@NonNull RegisterUserRequest registerUserRequest) throws ApiError {
    return this.registerUser(registerUserRequest, null);
  }

  /**
   * Method registerUser
   * POST /users/register
   *
   * @param registerUserRequest {@link RegisterUserRequest} Request Body
   * @return response of {@code Object}
   */
  public Object registerUser(
    @NonNull RegisterUserRequest registerUserRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.registerUserConfig, requestConfig);
    Request request = this.buildRegisterUserRequest(registerUserRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method registerUser
   * POST /users/register
   *
   * @param registerUserRequest {@link RegisterUserRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> registerUserAsync(
    @NonNull RegisterUserRequest registerUserRequest
  ) throws ApiError {
    return this.registerUserAsync(registerUserRequest, null);
  }

  /**
   * Method registerUser
   * POST /users/register
   *
   * @param registerUserRequest {@link RegisterUserRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> registerUserAsync(
    @NonNull RegisterUserRequest registerUserRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.registerUserConfig, requestConfig);
    Request request = this.buildRegisterUserRequest(registerUserRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildRegisterUserRequest(
    @NonNull RegisterUserRequest registerUserRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "users/register"
    )
      .setJsonContent(registerUserRequest)
      .build();
  }

  /**
   * Method login
   * POST /users/login
   *
   * @param loginRequest {@link LoginRequest} Request Body
   * @return response of {@code Object}
   */
  public Object login(@NonNull LoginRequest loginRequest) throws ApiError {
    return this.login(loginRequest, null);
  }

  /**
   * Method login
   * POST /users/login
   *
   * @param loginRequest {@link LoginRequest} Request Body
   * @return response of {@code Object}
   */
  public Object login(@NonNull LoginRequest loginRequest, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.loginConfig, requestConfig);
    Request request = this.buildLoginRequest(loginRequest, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method login
   * POST /users/login
   *
   * @param loginRequest {@link LoginRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> loginAsync(@NonNull LoginRequest loginRequest) throws ApiError {
    return this.loginAsync(loginRequest, null);
  }

  /**
   * Method login
   * POST /users/login
   *
   * @param loginRequest {@link LoginRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> loginAsync(
    @NonNull LoginRequest loginRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.loginConfig, requestConfig);
    Request request = this.buildLoginRequest(loginRequest, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildLoginRequest(
    @NonNull LoginRequest loginRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "users/login"
    )
      .setJsonContent(loginRequest)
      .build();
  }

  /**
   * Method getUserProfile
   * GET /users/{userId}
   *
   * @param userId String
   * @return response of {@code Object}
   */
  public Object getUserProfile(@NonNull String userId) throws ApiError {
    return this.getUserProfile(userId, null);
  }

  /**
   * Method getUserProfile
   * GET /users/{userId}
   *
   * @param userId String
   * @return response of {@code Object}
   */
  public Object getUserProfile(@NonNull String userId, RequestConfig requestConfig)
    throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getUserProfileConfig, requestConfig);
    Request request = this.buildGetUserProfileRequest(userId, resolvedConfig);
    Response response = this.execute(request, resolvedConfig);
    byte[] bodyBytes = ModelConverter.readBytes(response);
    return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
  }

  /**
   * Method getUserProfile
   * GET /users/{userId}
   *
   * @param userId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getUserProfileAsync(@NonNull String userId) throws ApiError {
    return this.getUserProfileAsync(userId, null);
  }

  /**
   * Method getUserProfile
   * GET /users/{userId}
   *
   * @param userId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getUserProfileAsync(
    @NonNull String userId,
    RequestConfig requestConfig
  ) throws ApiError {
    RequestConfig resolvedConfig = this.getResolvedConfig(this.getUserProfileConfig, requestConfig);
    Request request = this.buildGetUserProfileRequest(userId, resolvedConfig);
    CompletableFuture<Response> futureResponse = this.executeAsync(request, resolvedConfig);
    return futureResponse.thenApplyAsync(response -> {
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return ModelConverter.convert(bodyBytes, new TypeReference<Object>() {});
    });
  }

  private Request buildGetUserProfileRequest(@NonNull String userId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.API),
      "users/{userId}"
    )
      .setPathParameter("userId", userId)
      .build();
  }
}
