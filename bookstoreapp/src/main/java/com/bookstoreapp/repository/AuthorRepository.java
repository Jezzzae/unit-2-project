package com.bookstoreapp.repository;

import com.bookstoreapp.model.Author
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


}


@Repository
public interface AuthorRepository  extends JpaRepository<Author, Long> {
    // to register
    boolean existsByFirstName(String authorfirstName);

    // to login
    User findUserByEmailAddress(String userEmailAddress);
}