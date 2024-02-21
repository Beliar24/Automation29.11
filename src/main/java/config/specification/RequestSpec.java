package config.specification;

import config.configuration.AccountConfig;
import dto.response.account.GenerateTokenResponseDTO;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

import static config.base.Requests.postForToken;
import static config.builders.UserBuilders.user;
import static config.specification.ResponseSpec.ok;
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
    private static String token = null;

    public static RequestSpecification commonSpecRequest() {
        return baseSpecRequest()
                .filters(
                new RequestLoggingFilter(METHOD),
                new RequestLoggingFilter(URI),
                new RequestLoggingFilter(PARAMS),
                new RequestLoggingFilter(BODY))
                .header(getAccessToken());
    }

    public static RequestSpecification baseSpecRequest() {
        return given()
                .relaxedHTTPSValidation()
                .baseUri(URL)
                .accept(JSON)
                .contentType(JSON);
    }

    private static Header getAccessToken() {
        Header header = null;
        if (token == null) {
            token = getToken();
        }
        header = new Header("Authorization", format("Bearer %s", token));
        return header;
    }

    private static String getToken() {
        return postForToken(user(), config.generateToken()).spec(ok()).extract().as(GenerateTokenResponseDTO.class).getToken();
    }
}
