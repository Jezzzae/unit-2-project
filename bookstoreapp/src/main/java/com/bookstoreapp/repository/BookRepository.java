package com.bookstoreapp.repository;

import com.bookstoreapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


//testing 1234567
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}

