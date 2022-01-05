package com.bookstoreapp.repository;

import com.bookstoreapp.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}

