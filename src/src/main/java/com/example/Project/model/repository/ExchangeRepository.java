package com.example.Project.model.repository;

import com.example.Project.model.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {
    // Additional query methods if needed
}