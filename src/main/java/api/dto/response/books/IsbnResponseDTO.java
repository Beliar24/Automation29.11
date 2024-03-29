package api.dto.response.books;

import api.dto.request.book.IsbnRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IsbnResponseDTO {
    private List<IsbnRequestDTO> books;
}
