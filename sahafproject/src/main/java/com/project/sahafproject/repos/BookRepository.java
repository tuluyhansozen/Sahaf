package com.project.sahafproject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sahafproject.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByBookstoreId(Long bookstoreId);

}
