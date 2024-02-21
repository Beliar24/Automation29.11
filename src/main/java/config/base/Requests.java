package config.base;

import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static config.specification.RequestSpec.baseSpecRequest;
import static config.specification.RequestSpec.commonSpecRequest;

public class Requests {

    public static <T> ValidatableResponse post(T body, String endpoint) {
        return commonSpecRequest().body(body).post(endpoint).then();
    }

    public static <T, H> ValidatableResponse post(Map<String, H> headers, T body, String endpoint) {
        return commonSpecRequest().headers(headers).body(body).post(endpoint).then();
    }

    public static <T> ValidatableResponse postForToken(T body, String endpoint) {
        return baseSpecRequest().body(body).post(endpoint).then();
    }

    public static <T> ValidatableResponse post(T body, String endpoint, Object... params) {
        return commonSpecRequest().body(body).post(endpoint, params).then();
    }

    public static ValidatableResponse get(String endpoint, Object ...params) {
        return commonSpecRequest().get(endpoint, params).then();
    }

    public static ValidatableResponse get(String endpoint) {
        return commonSpecRequest().get(endpoint).then();
    }

    public static ValidatableResponse delete(String endpoint, Object ...params) {
        return commonSpecRequest().delete(endpoint, params).then();
    }

    public static <T> ValidatableResponse put(T body, String endpoint) {
        return commonSpecRequest().body(body).put(endpoint).then();
    }

    public static <T> ValidatableResponse put(T body, String endpoint, Object ...params) {
        return commonSpecRequest().body(body).put(endpoint, params).then();
    }
}
