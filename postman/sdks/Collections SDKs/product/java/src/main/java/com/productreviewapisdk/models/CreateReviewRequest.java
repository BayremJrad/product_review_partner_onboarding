package com.productreviewapisdk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateReviewRequest {

  @JsonProperty("rating")
  private JsonNullable<Double> rating;

  @JsonProperty("title")
  private JsonNullable<String> title;

  @JsonProperty("body")
  private JsonNullable<String> body;

  @JsonProperty("userId")
  private JsonNullable<String> userId;

  @JsonIgnore
  public Double getRating() {
    return rating.orElse(null);
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonIgnore
  public String getBody() {
    return body.orElse(null);
  }

  @JsonIgnore
  public String getUserId() {
    return userId.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateReviewRequestBuilder {

    private JsonNullable<Double> rating = JsonNullable.undefined();

    @JsonProperty("rating")
    public CreateReviewRequestBuilder rating(Double value) {
      this.rating = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> title = JsonNullable.undefined();

    @JsonProperty("title")
    public CreateReviewRequestBuilder title(String value) {
      this.title = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> body = JsonNullable.undefined();

    @JsonProperty("body")
    public CreateReviewRequestBuilder body(String value) {
      this.body = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> userId = JsonNullable.undefined();

    @JsonProperty("userId")
    public CreateReviewRequestBuilder userId(String value) {
      this.userId = JsonNullable.of(value);
      return this;
    }
  }
}
