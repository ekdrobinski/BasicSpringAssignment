package com.example.simplespringapp7;

import com.example.simplespringapp7.model.Author;
import com.example.simplespringapp7.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AuthorTest {
    private Author author;
    private List<Book> books;

    @BeforeEach
    public void setup() {
        books = new ArrayList<>();
        books.add();
        books.add(;
        author = new Author("John Doe", books);
    }

    @Test
    public void testGetId() {
        Assertions.assertNull(author.getId());
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("John Doe", author.getName());
    }

    @Test
    public void testSetName() {
        author.setName("Jane Smith");
        Assertions.assertEquals("Jane Smith", author.getName());
    }

    @Test
    public void testGetBooks() {
        Assertions.assertEquals(2, author.getBooks().size());
    }

    @Test
    public void testSetBooks() {
        List<Book> newBooks = new ArrayList<>();
        newBooks.add(new Book("Book 3"));
        author.setBooks(newBooks);
        Assertions.assertEquals(1, author.getBooks().size());
        Assertions.assertEquals("Book 3", author.getBooks().get(0).getTitle());
    }
}

