package com.example.Project.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String BookName;
    private Integer bookId;
    private String reason;
    private String status; // e.g., "pending", "resolved", "rejected"

    // Default constructor
    public Report() {
    }

    // Parameterized constructor
    public Report(Integer bookId, String reason, String status) {
        this.bookId = bookId;
        this.reason = reason;
        this.status = status;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Additional method to get report details as a string
    public String getDetails() {
        return "Report ID: " + id +
                ", Book ID: " + bookId +
                ", Reason: " + reason +
                ", Status: " + status;
    }

    // Method to update the status of the report
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }
}