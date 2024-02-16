package config.base;

import io.restassured.response.ValidatableResponse;

import static config.specification.RequestSpec.baseSpecRequest;

public class Requests {

    public static <T> ValidatableResponse post(T body, String endpoint) {
        return baseSpecRequest().body(body).post(endpoint).then();
    }

    public static <T> ValidatableResponse post(T body, String endpoint, Object... params) {
        return baseSpecRequest().body(body).post(endpoint, params).then();
    }

    public static ValidatableResponse get(String endpoint, Object ...params) {
        return baseSpecRequest().get(endpoint, params).then();
    }

    public static ValidatableResponse get(String endpoint) {
        return baseSpecRequest().get(endpoint).then();
    }

    public static ValidatableResponse delete(String endpoint, Object ...params) {
        return baseSpecRequest().delete(endpoint, params).then();
    }

    public static <T> ValidatableResponse put(T body, String endpoint) {
        return baseSpecRequest().body(body).put(endpoint).then();
    }

    public static <T> ValidatableResponse put(T body, String endpoint, Object ...params) {
        return baseSpecRequest().body(body).put(endpoint, params).then();
    }
}
