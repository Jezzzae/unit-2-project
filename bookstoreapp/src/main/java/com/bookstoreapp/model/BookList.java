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

    @ManyToMany(mappedBy = "booklist")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<Book> bookList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public BookList(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public BookList() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    public List<Book> getBookList() {
        return bookList;
    }

    public void setMusicList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}