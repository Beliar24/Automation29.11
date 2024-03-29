package api.config.specification;

import api.config.base.token.GenerateToken;
import api.config.configuration.AccountConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.METHOD;
import static io.restassured.filter.log.LogDetail.PARAMS;
import static io.restassured.filter.log.LogDetail.URI;
import static io.restassured.http.ContentType.JSON;
import static java.lang.String.format;
import static org.aeonbits.owner.ConfigFactory.create;
import static org.aeonbits.owner.ConfigFactory.getProperties;

public class RequestSpec {

    private static final AccountConfig config = create(AccountConfig.class, getProperties());
    private static final String URL = config.url();

    public static RequestSpecification commonSpecRequest() {
        return baseSpec(URL)
                .filters(
                new RequestLoggingFilter(METHOD),
                new RequestLoggingFilter(URI),
                new RequestLoggingFilter(PARAMS),
                new RequestLoggingFilter(BODY))
                .header(getAccessToken());
    }

    public static RequestSpecification baseSpecRequest() {
        return baseSpec(URL)
                .filters(
                        new RequestLoggingFilter(METHOD),
                        new RequestLoggingFilter(URI),
                        new RequestLoggingFilter(PARAMS));
    }

    private static RequestSpecification baseSpec(String url) {
        return given()
                .relaxedHTTPSValidation()
                .baseUri(url)
                .accept(JSON)
                .contentType(JSON);
    }

    private static Header getAccessToken() {
        return new Header("Authorization", String.format("Bearer %s", GenerateToken.getToken()));
    }
}
