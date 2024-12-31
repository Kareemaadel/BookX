package com.example.Project.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin  {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id      ;  // You can generate this ID (e.g., UUID)

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String email;
    private String name;
    private String password;
    private boolean allpermmissions;

    public Admin() {
        // Default constructor
        super();  // Call the parent constructor
    }


    public boolean isAllpermmissions() {
        return allpermmissions;
    }

    public void setAllpermmissions(boolean allpermmissions) {
        this.allpermmissions = allpermmissions;
    }
}