package com.bookstoreapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
        import org.hibernate.annotations.LazyCollection;
        import org.hibernate.annotations.LazyCollectionOption;

        import javax.persistence.*;
        import java.util.List;

@Entity
@Table(name = "booklist")
public class BookList {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

}