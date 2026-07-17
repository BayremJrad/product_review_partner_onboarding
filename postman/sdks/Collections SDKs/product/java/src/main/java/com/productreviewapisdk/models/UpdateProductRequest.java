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
public class UpdateProductRequest {

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("price")
  private JsonNullable<Double> price;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public Double getPrice() {
    return price.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class UpdateProductRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public UpdateProductRequestBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> price = JsonNullable.undefined();

    @JsonProperty("price")
    public UpdateProductRequestBuilder price(Double value) {
      this.price = JsonNullable.of(value);
      return this;
    }
  }
}
