package api.dto.response.account;

import api.dto.response.books.BookResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDTO {
    private String userId;
    private String username;
    private List<BookResponseDTO> books;
}
