package com.project.sahafproject.request;

public class BookstoreDTO {

	private Long id;
    private String name;
    private String location;

    // Getters and Setters

    public Long getUserId() {
        return id;
    }

    public void setUserId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
