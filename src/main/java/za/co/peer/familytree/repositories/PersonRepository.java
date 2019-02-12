package za.co.peer.familytree.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import za.co.peer.familytree.domains.Person;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    List<Person> findAll();

    Person findByNameLike(@Param("name") String name);

    Person save(Person person);
}
