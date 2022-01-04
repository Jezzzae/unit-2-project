package com.bookstoreapp.model;

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


}
