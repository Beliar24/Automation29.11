package config.specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.apache.http.HttpStatus.SC_OK;

public class ResponseSpec {

    public static ResponseSpecification ok() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_OK)
                .build();
    }
}
