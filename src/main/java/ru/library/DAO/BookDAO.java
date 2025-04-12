package ru.library.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.library.models.Book;

import java.util.List;

@Component
public class BookDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<Book>(Book.class));
    }

    public Book show(int book_id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE book_id=?", new Object[]{book_id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findFirst().orElse(null);
    }

    public List<Book> showByPerson(int person_id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id=?", new Object[]{person_id}, new BeanPropertyRowMapper<>(Book.class));

    }

    public void save(Book book) {
        jdbcTemplate.update("insert into book(title, author, publicationYear) values(?,?,?)", book.getTitle(), book.getAuthor(), book.getPublicationYear());
    }

    public void update(Book book, int book_id) {
        jdbcTemplate.update("UPDATE book SET person_id = ?, title = ?,  author = ?, publicationYear = ? WHERE book_id = ?", book.getPerson_id(), book.getTitle(), book.getAuthor(), book.getPublicationYear(), book_id);
    }

    public void delete(int book_id) {
        jdbcTemplate.update("delete from book where book_id = ?", book_id);
    }







































}
