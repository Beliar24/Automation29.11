package api.dto.response.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {
    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private Date publish_date;
    private String publisher;
    private int pages;
    private String description;
    private String website;
}
