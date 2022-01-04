package com.bookstoreapp.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Genre")
public class Genre {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    Set<Book> books;
}
