package com.example.simplespringapp7.controller;

import com.example.simplespringapp7.model.Author;
import com.example.simplespringapp7.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String getAllAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "author-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "author-create";
    }

    @PostMapping("/create")
    public String createAuthor(@ModelAttribute("author") Author author) {
        authorRepository.save(author);
        return "redirect:/";
    }


    @GetMapping("/update")
    public String showUpdateAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "author-update";
    }

    @GetMapping("/update/{id}")
    public String showUpdateAuthorForm(@PathVariable("id") Long id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author ID: " + id));
        model.addAttribute("author", author);
        return "author-edit-update";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable("id") Long id, @ModelAttribute("author") Author updatedAuthor) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author ID: " + id));

        author.setName(updatedAuthor.getName());
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/confirm-delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Author author = authorRepository.findById(id).orElse(null);
        model.addAttribute("author", author);
        return "author-delete";
    }

    @GetMapping("/delete")
    public String showDeleteAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "author-delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }

}