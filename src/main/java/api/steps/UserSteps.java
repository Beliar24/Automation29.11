package api.steps;

import api.config.base.requestImpl.CommonRequestHandler;
import api.config.configuration.AccountConfig;
import api.dto.response.account.GetUserResponseDTO;
import io.qameta.allure.Step;

import static api.config.specification.ResponseSpec.ok;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.aeonbits.owner.ConfigFactory.create;
import static org.aeonbits.owner.ConfigFactory.getProperties;

public class UserSteps {

    private final AccountConfig config = create(AccountConfig.class, getProperties());
    private final CommonRequestHandler request = new CommonRequestHandler();

    @Step("Get user with book or not")
    public GetUserResponseDTO getUser() {
        return request.get(config.getUser(), config.userId())
                .spec(ok())
                .body(matchesJsonSchemaInClasspath("schemas/GetUserJsonSchema.json"))
                .extract().as(GetUserResponseDTO.class);
    }

}
