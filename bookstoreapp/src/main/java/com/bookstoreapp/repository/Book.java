package com.bookstoreapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Book extends JpaRepository<Book, Long> {
}

