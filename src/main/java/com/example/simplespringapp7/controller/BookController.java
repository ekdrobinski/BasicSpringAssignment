package com.example.simplespringapp7.controller;

import com.example.simplespringapp7.model.Author;
import com.example.simplespringapp7.model.Book;
import com.example.simplespringapp7.repository.AuthorRepository;
import com.example.simplespringapp7.repository.BookRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        Book book = bookRepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "book-details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Author> authors = authorRepository.findAll(); // Assuming you have an instance of AuthorRepository
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authors);
        return "book-create";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }


    @GetMapping("/update")
    public String showUpdateBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-update";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));
        model.addAttribute("book", book);
        return "book-edit-update";
    }


    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book updatedBook) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));

        book.setTitle(updatedBook.getTitle());
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete")
    public String showDeleteBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

}