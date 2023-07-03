package com.example.simplespringapp7.repository;

import com.example.simplespringapp7.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

