package za.co.peer.familytree.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.peer.familytree.domains.Person;
import za.co.peer.familytree.repositories.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public Person findByName(String name) {
        Person person = this.personRepository.findByNameLike(name);
        return person;
    }

    @Transactional(readOnly = true)
    public List<Person> findAll() {
        List<Person> persons = this.personRepository.findAll();
        return persons;
    }

    @Transactional
    public Person save(Person person) {
        Person savedPerson = this.personRepository.save(person);
        return savedPerson;
    }
}
