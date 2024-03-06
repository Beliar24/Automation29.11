package config.base.token;

import config.base.requestImpl.BaseRequestHandler;
import config.configuration.AccountConfig;
import dto.response.account.GenerateTokenResponseDTO;

import static config.builders.UserBuilders.user;
import static config.specification.ResponseSpec.ok;
import static org.aeonbits.owner.ConfigFactory.create;
import static org.aeonbits.owner.ConfigFactory.getProperties;

public class GenerateToken {

    private static String token = null;
    private static final AccountConfig config = create(AccountConfig.class, getProperties());
    private static final BaseRequestHandler request = new BaseRequestHandler();
    private GenerateToken() {}

    public static String getToken() {
        if (token == null) {
            synchronized (GenerateToken.class) {
                if (token == null) {
                    token = request.post(user(), config.generateToken()).spec(ok()).extract()
                            .as(GenerateTokenResponseDTO.class).getToken();
                }
            }
        }
        return token;
    }

}
