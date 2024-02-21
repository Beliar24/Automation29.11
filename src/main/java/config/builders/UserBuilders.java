package config.builders;

import dto.request.account.GenerateTokenRequestDTO;

public class UserBuilders {

    public static GenerateTokenRequestDTO user() {
        return GenerateTokenRequestDTO.builder()
                .userName("user15")
                .password("123456Qa!")
                .build();
    }
}
