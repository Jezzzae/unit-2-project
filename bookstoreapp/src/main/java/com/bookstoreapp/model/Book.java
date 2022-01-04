package com.bookstoreapp.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @ManyToMany
    Set<Author> authors;
}
