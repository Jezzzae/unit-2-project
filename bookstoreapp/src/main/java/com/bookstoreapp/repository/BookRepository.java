package com.bookstoreapp.repository;

import com.bookstoreapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


//testing fddfddff
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}

