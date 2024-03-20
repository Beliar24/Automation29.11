package api.config.base.request;

import io.restassured.response.ValidatableResponse;

import java.util.Map;

public interface RequestPostHeader {
    <T, H> ValidatableResponse post(Map<String, H> headers, T body, String endpoint);
}
