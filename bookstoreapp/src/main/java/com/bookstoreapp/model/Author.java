package com.bookstoreapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "Author")
public class Author {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String authorBio;

    @Column
    private String bookName;

    @Column
    private String publisher;

    @JsonIgnore
    @OneToOne(mappedBy = "Author")
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author() {
    }

    public Author(Long id, String firstName, String lastName, String authorBio, String bookName, String publisher) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorBio = authorBio;
        this.bookName = bookName;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAuthorBio() {
        return authorBio;
    }

    public void setAuthorBio(String authorBio) {
        this.authorBio = authorBio;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", authorBio='" + authorBio + '\'' +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}