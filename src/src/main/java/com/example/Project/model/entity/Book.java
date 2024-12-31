package com.example.Project.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    private Integer userid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Auto-generated Integer ID
    private String title;
    private String author;
    private String genre;
    private String condition; // e.g., "available", "exchanged"

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(Integer userid, String title, String author, String genre, String condition) {
        this.userid = userid;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.condition = condition;
    }

    // Getters and Setters
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    // Additional method to return book details as a string
    public String getDetails() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Condition: " + condition;
    }

    // Method to update the status/condition of the book
    public void updateCondition(String newCondition) {
        this.condition = newCondition;
    }
}
