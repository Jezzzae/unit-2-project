package com.bookstoreapp.repository;

import com.bookstoreapp.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {


    List<Author> findByBookId(Long bookId);


    Author findByLastName(String lastName);


}

