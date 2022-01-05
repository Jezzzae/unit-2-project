package com.bookstoreapp.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


@Entity
@Table(name = "Authors")
public class Author {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}