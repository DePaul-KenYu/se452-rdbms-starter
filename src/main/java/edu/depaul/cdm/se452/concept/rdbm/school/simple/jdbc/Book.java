package edu.depaul.cdm.se452.concept.rdbm.school.simple.jdbc;

import lombok.Data;

@Data
public class Book {
    private long id;
    private String isbn;
    private String title;
    private String author;        
}
