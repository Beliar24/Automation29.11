package api.config.builders;

import api.dto.request.account.GenerateTokenRequestDTO;

public class UserBuilders {

    public static GenerateTokenRequestDTO user() {
        return GenerateTokenRequestDTO.builder()
                .userName(System.getProperty("username"))
                .password(System.getProperty("password"))
                .build();
    }
}
//123456Qa!
//user15