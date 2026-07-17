package com.productreviewapisdk.http;

import lombok.Getter;

/**
 * Predefined environment configurations for the SDK.
 * Each environment represents a different base URL (e.g., production, staging, development).
 */
@Getter
public enum Environment {
  DEFAULT("https://api.productreview.com/v1"),
  API("https://api.productreview.com/v1");

  private final String url;

  Environment(String url) {
    this.url = url;
  }
}
