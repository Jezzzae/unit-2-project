package com.bookstoreapp.repository;

import com.bookstoreapp.model.Author;
import com.bookstoreapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AuthorRepository  extends JpaRepository<Author, Long> {

    List<Author> findByName(String authorName);

    List<Author> findByauthorId (String authorId);

    List<Author> findByGenreId(Long genreId);

    List<Author> findByPublisherId(Long publisherId);

    List<Author> findByBookId(Long bookId);
}