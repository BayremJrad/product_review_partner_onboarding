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
public class RegisterUserRequest {

  @JsonProperty("name")
  private JsonNullable<String> name;

  @JsonProperty("email")
  private JsonNullable<String> email;

  @JsonProperty("password")
  private JsonNullable<String> password;

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonIgnore
  public String getEmail() {
    return email.orElse(null);
  }

  @JsonIgnore
  public String getPassword() {
    return password.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class RegisterUserRequestBuilder {

    private JsonNullable<String> name = JsonNullable.undefined();

    @JsonProperty("name")
    public RegisterUserRequestBuilder name(String value) {
      this.name = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> email = JsonNullable.undefined();

    @JsonProperty("email")
    public RegisterUserRequestBuilder email(String value) {
      this.email = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<String> password = JsonNullable.undefined();

    @JsonProperty("password")
    public RegisterUserRequestBuilder password(String value) {
      this.password = JsonNullable.of(value);
      return this;
    }
  }
}
