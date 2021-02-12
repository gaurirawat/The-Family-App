package com.example.familyapp.Controllers;

import com.example.familyapp.Beans.Activity;
import com.example.familyapp.Services.ActivityService;
import com.example.familyapp.Utils.Wrappers.ActivityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/get")
    public Activity get(@RequestParam int id) {
        return activityService.get(id);
    }

    @PostMapping("/createTask")
    public Activity createTask(@RequestBody ActivityWrapper wrapper) {
        return activityService.createTask(wrapper.getName(), wrapper.getDescription(), wrapper.getDate(), wrapper.getPersonId(), wrapper.getCategory());
    }

    @PostMapping("/createEvent")
    public Activity createEvent(@RequestBody ActivityWrapper wrapper) {
        return activityService.createEvent(wrapper.getName(), wrapper.getDescription(), wrapper.getDate(), wrapper.getPersonId(), wrapper.getParticipantsToAdd());
    }

    @GetMapping("/getTasks")
    public List<Activity> getTasksByPersonId(@RequestParam int personId) {
        return activityService.getTasksByPersonId(personId);
    }

    @GetMapping("/getEvents")
    public List<Activity> getEventsByPersonId(@RequestParam int personId) {
        return activityService.getEventsByPersonId(personId);
    }
}
