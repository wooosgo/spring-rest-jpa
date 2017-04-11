package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by jonas on 05/04/2017.
 */

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    // List all Person
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Person> getPerson(){
        Iterable<Person> person = personRepository.findAll();
        return person;
    }

    // search Person by id
    // TODO : exception when id != long type
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id){
        Person person = personRepository.findOne(id);
        return person;
    }

//    // search Person by firstName
//    @RequestMapping(value = "/name", method = RequestMethod.GET)
//    public List<Person> getPerson(@RequestParam("firstName") String firstName){
//        List<Person> person = personRepository.findByFirstName(firstName);
//        return person;
//    }

    // search Person by both firstName & LastName
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public List<Person> getPerson(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName){
        List<Person> person = personRepository.findByFirstNameAndLastName(firstName,lastName);
        return person;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person addPerson(@RequestBody Person person){
        personRepository.save(person);
        return person;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Person addPersonWithSchedule(@RequestBody Person person, @RequestParam(value="program") String program){
        personRepository.save(person);
        Date lastModifiedDt = new Date();

        Schedule sc = new Schedule(person, program,lastModifiedDt);
        scheduleRepository.save(sc);
        return person;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Long id){
        personRepository.delete(id);
        System.out.println("deleted person with ID=" + id + "\n");
        return;
    }

}
