package com.bookstoreapp.model;

<<<<<<< HEAD
@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column
    private Long id;

    @Column
    private String bookTitle;

    @Column
    private int pageLength;

    //do i include foreign keys ??
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getPageLength() {
        return pageLength;
    }

    public void setPageLength(int pageLength) {
        this.pageLength = pageLength;
    }

    public Book(Long id, String bookTitle, int pageLength,){
        this.id = id;
        this.bookTitle = bookTitle;
        this.pageLength = pageLength;
    }
    public Book(){
        //default ctor
    }

    
    //fav list
    //genre
    //publisher
    //author


=======

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
>>>>>>> a8ccdac4af21f7dc76a6212a9e6f92a1247ce8ec
}
