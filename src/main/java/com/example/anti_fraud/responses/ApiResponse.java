package com.example.anti_fraud.responses;

public class ApiResponse<T> {
  private boolean success;
  private T data;
  private ApiError error;

  public ApiResponse(boolean success, T data, ApiError error) {
      this.success = success;
      this.data = data;
      this.error = error;
  }

  public boolean isSuccess() { return success; }
  public void setSuccess(boolean success) { this.success = success; }

  public T getData() { return data; }
  public void setData(T data) { this.data = data; }

  public ApiError getError() { return error; }
  public void setError(ApiError error) { this.error = error; }

  // Métodos de fábrica
  public static <T> ApiResponse<T> ok(T data) {
      return new ApiResponse<>(true, data, null);
  }

  public static <T> ApiResponse<T> fail(String code, String message) {
      return new ApiResponse<T>(false, null, new ApiError(code, message));
  }
}