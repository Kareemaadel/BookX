package com.example.Project.model.repository;

import com.example.Project.model.entity.Book;
import com.example.Project.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByUserid(Integer userid);
   // Book findbyids(Integer userid, Integer id);

    List<Book> findByTitleContainingIgnoreCase(String title);

}
