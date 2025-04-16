package ru.library.services;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.library.models.Book;
import ru.library.models.Person;
import ru.library.repositories.PeopleRepositories;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepositories peopleRepositories;

    @Autowired
    public PeopleService(PeopleRepositories peopleRepositories) {
        this.peopleRepositories = peopleRepositories;
    }

    public List<Person> findAll(){
        return peopleRepositories.findAll();
    }

    public Person findOne(int id){
        Optional<Person> foundPerson = peopleRepositories.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(Person person){
        peopleRepositories.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson){
        updatedPerson.setId(id);
        peopleRepositories.save(updatedPerson);
    }

    @Transactional
    public void delete(int id){
        peopleRepositories.deleteById(id);
    }

   public List<Book> getBooksByPersonId(int id){
        Optional<Person> person = peopleRepositories.findById(id);

        if(person.isPresent()){
            Hibernate.initialize(person.get().getBooks());
            return person.get().getBooks();
        }
        else{
            return Collections.emptyList();
        }
   }
}
