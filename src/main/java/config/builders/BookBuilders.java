package config.builders;

import dto.request.book.AddBookRequestDTO;
import dto.request.book.IsbnRequestDTO;

import java.util.List;

public class BookBuilders {

    public static AddBookRequestDTO book(String id, String isbn) {
        return AddBookRequestDTO.builder()
                .userId(id)
                .collectionOfIsbns(List.of(
                        IsbnRequestDTO.builder()
                                .isbn(isbn)
                                .build())
                )
                .build();
    }
}
