package com.github.torento2.bookcatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String author;
    @NotBlank
    @Column
    private String title;
    @NotBlank
    @Size(min = 1, max = 2500)
    @Column
    private String description;
    @NotNull
    @Column
    private String isbn;
    @NotNull
    @Column
    private Integer year;
}