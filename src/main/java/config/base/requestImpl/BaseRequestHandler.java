package config.base.requestImpl;

import config.base.request.RequestHandler;
import io.restassured.response.ValidatableResponse;

import static config.specification.RequestSpec.baseSpecRequest;

public class BaseRequestHandler implements RequestHandler {
    @Override
    public <T> ValidatableResponse post(T body, String endpoint, Object... params) {
        return baseSpecRequest().body(body).post(endpoint, params).then();
    }

    @Override
    public ValidatableResponse get(String endpoint, Object... params) {
        return baseSpecRequest().get(endpoint, params).then();
    }

    @Override
    public ValidatableResponse delete(String endpoint, Object... params) {
        return baseSpecRequest().delete(endpoint, params).then();
    }

    @Override
    public <T> ValidatableResponse put(T body, String endpoint, Object... params) {
        return baseSpecRequest().body(body).put(endpoint, params).then();
    }
}
