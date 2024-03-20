package api.config.base.request;

import io.restassured.response.ValidatableResponse;

import java.util.Map;

public interface RequestHandler {

    <T> ValidatableResponse post(T body, String endpoint, Object... params);
    ValidatableResponse get(String endpoint, Object ...params);
    ValidatableResponse delete(String endpoint, Object ...params);
    <T> ValidatableResponse put(T body, String endpoint, Object ...params);
}
