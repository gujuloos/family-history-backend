package za.co.peer.familytree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.peer.familytree.domains.Person;
import za.co.peer.familytree.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{name}")
    public Person findPersonByName(@PathVariable("name") String name) {
        return this.personService.findByName(name);
    }

    @GetMapping
    public List<Person> findAllPersons() {
        return this.personService.findAll();
    }
}
