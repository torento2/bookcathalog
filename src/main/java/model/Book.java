package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@AllArgsConstructor

@NoArgsConstructor

public class Book {


    private Long id;

    private String author;

    private String title;

    private String isbn;

    private String description;

    private String year;
}