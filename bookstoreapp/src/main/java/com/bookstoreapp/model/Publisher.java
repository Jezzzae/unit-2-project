package com.bookstoreapp.model;

import javax.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Publisher")
public class Publisher {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String publisherName;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
