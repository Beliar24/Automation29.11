package config.base.requestImpl;

import config.base.request.RequestPostHeader;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static config.specification.RequestSpec.commonSpecRequest;

public class CommonRequestHandler extends BaseRequestHandler implements RequestPostHeader {

    @Override
    public <T> ValidatableResponse post(T body, String endpoint, Object... params) {
        return commonSpecRequest().body(body).post(endpoint, params).then();
    }

    @Override
    public ValidatableResponse get(String endpoint, Object... params) {
        return commonSpecRequest().get(endpoint, params).then();
    }

    @Override
    public <T, H> ValidatableResponse post(Map<String, H> headers, T body, String endpoint) {
        return commonSpecRequest().headers(headers).body(body).post(endpoint).then();
    }

    @Override
    public <T> ValidatableResponse put(T body, String endpoint, Object ...params) {
        return commonSpecRequest().body(body).put(endpoint, params).then();
    }

    @Override
    public ValidatableResponse delete(String endpoint, Object ...params) {
        return commonSpecRequest().delete(endpoint, params).then();
    }
}
