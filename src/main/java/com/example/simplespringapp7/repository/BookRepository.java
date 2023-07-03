package com.example.simplespringapp7.repository;

import com.example.simplespringapp7.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
