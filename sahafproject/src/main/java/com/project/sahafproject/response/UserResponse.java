package com.project.sahafproject.response;

public class UserResponse {

    private Long id;
    private String name;

    // Constructors, Getters, and Setters

    public UserResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

