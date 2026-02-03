package com.example.ptudj2ee_bai3.model;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String author;
}
