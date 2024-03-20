package api.config.base.requestImpl;

import api.config.base.request.RequestHandler;
import api.config.specification.RequestSpec;
import io.restassured.response.ValidatableResponse;

public class BaseRequestHandler implements RequestHandler {
    @Override
    public <T> ValidatableResponse post(T body, String endpoint, Object... params) {
        return RequestSpec.baseSpecRequest().body(body).post(endpoint, params).then();
    }

    @Override
    public ValidatableResponse get(String endpoint, Object... params) {
        return RequestSpec.baseSpecRequest().get(endpoint, params).then();
    }

    @Override
    public ValidatableResponse delete(String endpoint, Object... params) {
        return RequestSpec.baseSpecRequest().delete(endpoint, params).then();
    }

    @Override
    public <T> ValidatableResponse put(T body, String endpoint, Object... params) {
        return RequestSpec.baseSpecRequest().body(body).put(endpoint, params).then();
    }
}
