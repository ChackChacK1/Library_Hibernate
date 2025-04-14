package ru.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.library.models.Book;
import ru.library.services.BooksService;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BooksService booksService;

    @Autowired
    @Lazy
    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", booksService.findAll());
        return "books/index";
    }

    @GetMapping("/{book_id}")
    public String show(@PathVariable("book_id") int book_id, Model model) {
        model.addAttribute("book", booksService.findOne(book_id));
//        model.addAttribute("people", personDAO.index());
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping
    public String create(@ModelAttribute("book") Book book) {
        booksService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{book_id}/edit")
    public String edit(@PathVariable("book_id") int book_id, Model model) {
        model.addAttribute("book", booksService.findOne(book_id));
        return "books/edit";
    }

    @PatchMapping("/{bood_id}")
    public String update(@ModelAttribute("book") Book book, @PathVariable("bood_id") int book_id) {
        booksService.update(book_id, book);
        return "redirect:/books/" + book_id;
    }

    @DeleteMapping("/{book_id}")
    public String delete(@PathVariable("book_id") int book_id) {
        booksService.delete(book_id);
        return "redirect:/books/";
    }
}
