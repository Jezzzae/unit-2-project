package com.bookstoreapp.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Publisher")
public class Publisher {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String publisherName;

    @ManyToMany
    Set<Publisher> publishers;
}
