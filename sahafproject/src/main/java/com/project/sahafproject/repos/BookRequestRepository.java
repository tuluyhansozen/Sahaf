package com.project.sahafproject.repos;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.sahafproject.entities.Book;
import com.project.sahafproject.entities.BookRequest;

public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {

    // Custom query to check if there exists any BookRequest that overlaps with the specified book and date range
    @Query("SELECT COUNT(br) > 0 FROM BookRequest br WHERE br.book = ?1 AND (?2 BETWEEN br.startDate AND br.endDate OR ?3 BETWEEN br.startDate AND br.endDate)")
    boolean existsByBookAndDateRange(Book book, Date startDate, Date endDate);

}
