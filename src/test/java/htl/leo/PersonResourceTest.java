package htl.leo;

import htl.leo.Person;
import htl.leo.PersonResource;
import io.quarkus.test.junit.QuarkusTest;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

// PersonResourceTest.java
@QuarkusTest
public class PersonResourceTest {

    @Inject
    PersonResource personResource;

    @Test
    public void testCreatePerson() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);

        Person createdPerson = personResource.createPerson(person);
        Assertions.assertNotNull(createdPerson);
        Assertions.assertEquals("John Doe", createdPerson.getName());
        Assertions.assertEquals(30, createdPerson.getAge());
    }

    @Test
    public void testGetAllPersons() {
        // Vorherige Personen in der Liste
        personResource.createPerson(new Person("Jane", 25));
        personResource.createPerson(new Person("Alice", 28));

        List<Person> persons = personResource.getAllPersons();
        Assertions.assertEquals(2, persons.size());
    }
}
