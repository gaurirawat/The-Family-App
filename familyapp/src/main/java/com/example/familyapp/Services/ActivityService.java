package com.example.familyapp.Services;

import com.example.familyapp.Beans.Activity;
import com.example.familyapp.Beans.Notification;
import com.example.familyapp.Beans.Person;
import com.example.familyapp.Repositories.ActivityRepository;
import com.example.familyapp.Repositories.PersonRepository;
import com.example.familyapp.Utils.Enums.ActivityTypeEnum;
import com.example.familyapp.Utils.Enums.CategoryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    NotificationService notificationService;

    public Activity get(int id) {
        return activityRepository.getOne(id);
    }

    public Activity createTask(String name, String description, Date date, int personId, CategoryEnum category) {
        Activity activity = new Activity(name, description, date, ActivityTypeEnum.TASK, category);
        Person person = personRepository.getOne(personId);
        activity.setCreatedBy(person);
        List<Activity> sameDaySameCategoryActivityList = activityRepository.getByCategoryAndDateAndType(category, date, ActivityTypeEnum.TASK);
        String message = "Same activity is being done by: " ;
        for (Activity activityFromList : sameDaySameCategoryActivityList) {
            Person otherPerson = activityFromList.getCreatedBy();
            notificationService.createNotification(otherPerson , message + person.getId());
            notificationService.createNotification(person, message + otherPerson.getId());
        }
        return activityRepository.save(activity);
    }

    public Activity createEvent(String name, String description, Date date, int personId, List<Person> participantsToAdd) {
        Activity activity = new Activity(name, description, date, ActivityTypeEnum.EVENT, null);
        Person creator = personRepository.getOne(personId);
        activity.setCreatedBy(creator);

        List<Person> participants = new ArrayList<Person>();
        String message = "You have been invited for event: "+ name;
        for(Person person: participantsToAdd) {
            participants.add(personRepository.getOne(person.getId()));
            notificationService.createNotification(person, message);
        }
        participants.add(creator);
        activity.setParticipants(participants);
        return activityRepository.save(activity);
    }


    public List<Activity> getTasksByPersonId(int personId) {
        List<Activity> activitiesCreated = personRepository.getOne(personId).getActivitiesCreated();
        System.out.println(activitiesCreated.size() + "size");
        List<Activity> tasks = new ArrayList<>();
        for (Activity activity : activitiesCreated) {
            if(activity.getType().equals(ActivityTypeEnum.TASK)) {
                tasks.add(activity);
                System.out.println("here");
            }
        }
        return tasks;
    }

    public List<Activity> getEventsByPersonId(int personId) {
        List<Activity> activitiesCreated = personRepository.getOne(personId).getActivitiesCreated();
        List<Activity> event = new ArrayList<>();
        for (Activity activity : activitiesCreated) {
            if(activity.getType().equals(ActivityTypeEnum.EVENT)) {
                event.add(activity);
            }
        }
        return event;
    }
}
