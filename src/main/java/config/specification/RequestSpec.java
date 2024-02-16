package config.specification;

import config.configuration.BaseConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.HEADERS;
import static io.restassured.filter.log.LogDetail.METHOD;
import static io.restassured.filter.log.LogDetail.URI;
import static io.restassured.http.ContentType.JSON;
import static org.aeonbits.owner.ConfigFactory.create;
import static org.aeonbits.owner.ConfigFactory.getProperties;

public class RequestSpec {

    private static final BaseConfig config = create(BaseConfig.class, getProperties());

    private static final String URL = config.url();

    public static RequestSpecification baseSpecRequest() {
        return given()
                .filters(new RequestLoggingFilter(METHOD),
                        new RequestLoggingFilter(URI),
                        new RequestLoggingFilter(HEADERS))
                .relaxedHTTPSValidation()
                .baseUri(URL)
                .accept(JSON)
                .contentType(JSON);
    }
}
