package com.bookstoreapp.model;



import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name="Users")
public class User {

    @Id
    @Column
    private  Long userId;

    @Column
    private String userName;

    @OneToMany
    Set<BookList> booklists;
    public User (){
        //default


    }
    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



}