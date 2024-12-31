package com.example.Project.service;

import com.example.Project.model.entity.Book;
import com.example.Project.model.entity.Exchange;
import com.example.Project.model.repository.BookRepository;
import com.example.Project.model.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExchangeService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Transactional
    public void performExchange(Exchange exchange) {
        // Retrieve the books using the IDs from the exchange
        Book book1 = bookRepository.findById(exchange.getBook1Id())
                .orElseThrow(() -> new RuntimeException("Book 1 not found"));
        Book book2 = bookRepository.findById(exchange.getBook2Id())
                .orElseThrow(() -> new RuntimeException("Book 2 not found"));

        // Update the condition of each book to "exchanged"
        book1.setCondition("exchanged");
        book2.setCondition("exchanged");

        // Save the updated books back to the database
        bookRepository.save(book1);
        bookRepository.save(book2);

        // Optionally, update the exchange status or perform other logic
        exchange.setStatus("completed");
        exchangeRepository.save(exchange);
    }
}