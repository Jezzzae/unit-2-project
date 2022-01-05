package com.bookstoreapp.repository;

import com.bookstoreapp.model.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByPublisherName(String publisherName);
}

