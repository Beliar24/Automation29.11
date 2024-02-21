package steps;

import config.configuration.AccountConfig;
import dto.response.account.GetUserResponseDTO;

import static config.base.Requests.get;
import static config.specification.ResponseSpec.ok;
import static org.aeonbits.owner.ConfigFactory.create;
import static org.aeonbits.owner.ConfigFactory.getProperties;

public class UserSteps {

    private final AccountConfig config = create(AccountConfig.class, getProperties());

    public GetUserResponseDTO getUser() {
        return get(config.getUser(), config.userId()).spec(ok()).extract().as(GetUserResponseDTO.class);
    }

}
