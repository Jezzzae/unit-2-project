package com.bookstoreapp.model;

import javax.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Genre")
public class Genre {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String subGenre;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
