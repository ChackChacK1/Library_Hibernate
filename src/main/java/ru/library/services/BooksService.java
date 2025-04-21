package ru.library.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.library.models.Book;
import ru.library.models.Person;
import ru.library.repositories.BooksRepositories;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepositories booksRepositories;

    @Autowired
    public BooksService(BooksRepositories booksRepositories) {
        this.booksRepositories = booksRepositories;
    }

    public List<Book> findAll(boolean sortByYear) {
        if (sortByYear) {
            return booksRepositories.findAll(Sort.by( "publicationYear"));
        }else{return booksRepositories.findAll();}
    }

    public List<Book> findWithPagination(Integer page, Integer booksPerPage, boolean sortByYear) {
        if (sortByYear) {
            return booksRepositories.findAll(PageRequest.of(page, booksPerPage, Sort.by("publicationYear"))).getContent();
        }else {
            return booksRepositories.findAll(PageRequest.of(page, booksPerPage)).getContent();
        }
    }

    public Book findOne(int id) {
        Optional<Book> book = booksRepositories.findById(id);
        return book.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepositories.save(book);
    }

    @Transactional
    public void update(int id, Book updateBook) {
        updateBook.setId(id);
        booksRepositories.save(updateBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepositories.deleteById(id);
    }

    public Person getBookOwner(int id) {
        return booksRepositories.findById(id).map(Book::getOwner).orElse(null);
    }

    @Transactional
    public void realise(int id) {
        booksRepositories.findById(id).ifPresent(book -> {
            book.setOwner(null);
        });
    }

    @Transactional
    public void assign(int id, Person selectedPerson) {
        booksRepositories.findById(id).ifPresent(book -> {book.setOwner(selectedPerson);});
    }

    public List<Book> search(String prefix) {
        return booksRepositories.findByTitleContainingIgnoreCase(prefix);
    }
}
