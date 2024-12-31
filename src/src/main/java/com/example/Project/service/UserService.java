package com.example.Project.service;


import com.example.Project.model.entity.Book;
import com.example.Project.model.entity.Exchange;
import com.example.Project.model.entity.Report;
import com.example.Project.model.entity.User;
import com.example.Project.model.repository.BookRepository;
import com.example.Project.model.repository.ExchangeRepository;
import com.example.Project.model.repository.ReportRepository;
import com.example.Project.model.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private ExchangeRepository exchangeRepository;



    public User SaveUser(User user) {

       return userRepository.save(user);
    }
    public Book addbook(Book book) {

        return bookRepository.save(book);
    }
    public Report addreport(Report report) {

        return reportRepository.save(report);
    }
    public List<Book> getBooksByUserId(Integer userId) {
        // Implement this method to fetch books from the repository
        return bookRepository.findByUserid(userId);


    }
    /*public Book getaBooksbyIsd(Integer userId1,Integer bookid1) {
        // Implement this method to fetch books from the repository
        return bookRepository.findbyids(userId1,bookid1);


    }*/
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null); // Handle user not found scenario
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}
