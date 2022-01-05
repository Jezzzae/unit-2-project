package com.bookstoreapp.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
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

    @OneToMany(mappedBy = "book", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Author> authorList;

    @OneToMany(mappedBy = "book", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Genre> genreList;

    @OneToMany(mappedBy = "book", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Publisher> publisherList;
}
