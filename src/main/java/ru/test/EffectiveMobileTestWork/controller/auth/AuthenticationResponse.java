package ru.test.EffectiveMobileTestWork.controller.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponse {
  public AuthenticationResponse() {
  }
  public AuthenticationResponse(String accessToken) {
    this.accessToken = accessToken;
  }

  private String accessToken;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
}
