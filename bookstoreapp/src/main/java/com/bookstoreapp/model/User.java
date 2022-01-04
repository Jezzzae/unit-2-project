package com.bookstoreapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column(unique = true)
    private String emailAddress;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    // user can have more than one song
    @ManyToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Book> bookList;

    // user can have more than one playlist
    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<BookList> booklist;

    public User(Long id, String name, String emailAddress, String password) {
        this.id = id;
        this.userName = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.booklist= booklist;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}