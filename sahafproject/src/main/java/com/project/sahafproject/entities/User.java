package com.project.sahafproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String name;


	
}
