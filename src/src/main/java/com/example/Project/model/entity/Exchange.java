package com.example.Project.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exchanges")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user1Id;
    private Integer user2Id;
    private Integer book1Id;
    private Integer book2Id;
    private String status;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Integer user1Id) {
        this.user1Id = user1Id;
    }

    public Integer getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    public Integer getBook1Id() {
        return book1Id;
    }

    public void setBook1Id(Integer book1Id) {
        this.book1Id = book1Id;
    }

    public Integer getBook2Id() {
        return book2Id;
    }

    public void setBook2Id(Integer book2Id) {
        this.book2Id = book2Id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}