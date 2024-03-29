package api.dto.request.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBookRequestDTO {
    private String userId;
    private List<IsbnRequestDTO> collectionOfIsbns;
}
