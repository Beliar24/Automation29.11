package api.dto.response.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenerateTokenResponseDTO {

    private String token;
    private Object expires;
    private String status;
    private String result;

}
