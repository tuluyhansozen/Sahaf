package com.project.sahafproject.entities;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Table(name = "book_requests")
@Data
public class BookRequest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
	
    Date startDate;
    Date endDate;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;
    
    @ManyToOne
    @JoinColumn(name = "bookstore_id")
    Bookstore bookstore;

}
