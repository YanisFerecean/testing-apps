package htl.leo;

import htl.leo.Person;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

// PersonResource.java
@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private static List<Person> persons = new ArrayList<>();
    private static Long idCounter = 1L;

    @GET
    public List<Person> getAllPersons() {
        return persons;
    }
    @POST
    public Person createPerson(Person person) {
        person.setId(idCounter++);
        persons.add(person);
        return person;
    }
}
