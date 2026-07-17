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
public class CreateProductRequest {

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("description")
  private JsonNullable<String> description;

  @JsonProperty("price")
  private JsonNullable<Double> price;

  @JsonProperty("category")
  private JsonNullable<String> category;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonIgnore
  public Double getPrice() {
    return price.orElse(null);
  }

  @JsonIgnore
  public String getCategory() {
    return category.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateProductRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public CreateProductRequestBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> description = JsonNullable.undefined();

    @JsonProperty("description")
    public CreateProductRequestBuilder description(String value) {
      this.description = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<Double> price = JsonNullable.undefined();

    @JsonProperty("price")
    public CreateProductRequestBuilder price(Double value) {
      this.price = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> category = JsonNullable.undefined();

    @JsonProperty("category")
    public CreateProductRequestBuilder category(String value) {
      this.category = JsonNullable.of(value);
      return this;
    }
  }
}
