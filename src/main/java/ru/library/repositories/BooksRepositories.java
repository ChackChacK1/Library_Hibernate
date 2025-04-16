package ru.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.library.models.Book;
import ru.library.models.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepositories extends JpaRepository<Book, Integer> {

}
