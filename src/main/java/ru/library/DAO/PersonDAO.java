package ru.library.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.library.models.Person;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int person_id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?", new Object[]{person_id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, birthDate) VALUES(?,?)", person.getName(), person.getBirthDate());
    }

    public void update(int person_id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, birthDate=? WHERE person_id=?", updatedPerson.getName(), updatedPerson.getBirthDate(), person_id);
    }

    public void delete(int person_id) {
        jdbcTemplate.update("DELETE FROM Person WHERE person_id=?", person_id);
    }
}
