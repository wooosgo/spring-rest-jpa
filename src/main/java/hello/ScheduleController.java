package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * Created by jonas on 05/04/2017.
 */

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value="{scheduleId}", method = RequestMethod.GET)
    public Schedule getSchedule(@PathVariable Long scheduleId){
        Schedule schedule = scheduleRepository.findOne(scheduleId);


//        @NotNull            // when to use this?
//        Person person = schedule.getPerson();

        if(schedule != null){
            Person person = schedule.getPerson();
        }

        return schedule;
    }

    @RequestMapping(value="{id}", method = RequestMethod.POST)
    public Schedule addSchedule(@PathVariable Long id, @RequestParam(value = "program") String program) {

        Person person = personRepository.findOne(id);
        Schedule schedule = null;

        Date lastModifiedDt = new Date();

        //TODO : exception when null
        if(person != null) {
            schedule = scheduleRepository.save(new Schedule(person, program, lastModifiedDt));
        }

        return schedule;
    }

//    @RequestMapping(value="/add/{id}", method = RequestMethod.POST)
//    @Transactional
//    public List<Schedule> addMoreSchedule(@PathVariable Long id, @RequestParam(value = "program") String program) {
//        Person person = personRepository.findOne(id);
//        Schedule schedule = scheduleRepository.save(new Schedule(person, program));
//
//        return person.getScheduleList();
//    }
}
