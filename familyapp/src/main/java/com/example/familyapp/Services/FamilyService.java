package com.example.familyapp.Services;

import com.example.familyapp.Beans.Checklist;
import com.example.familyapp.Beans.Family;
import com.example.familyapp.Beans.Notification;
import com.example.familyapp.Beans.Person;
import com.example.familyapp.Repositories.FamilyRepository;
import com.example.familyapp.Repositories.NotificationRepository;
import com.example.familyapp.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FamilyService {
    @Autowired
    FamilyRepository familyRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    NotificationService notificationService;

    public Family get(int familyId) {
        return familyRepository.getOne(familyId);
    }

    public Family createFamily(String name, String description, List<Person> newMembers, int creatorId) {
        Family family = new Family(name, newMembers.size(), description, false);
        List<Person> members = new ArrayList<Person>();
        String message = "You have been added to family: " + family.getName();
        for (Person member: newMembers) {
            Person person = personRepository.getOne(member.getId());
            members.add(person);
            notificationService.createNotification(person, message);
        }
        members.add(personRepository.getOne(creatorId));
        family.setMembers(members);
        return familyRepository.save(family);
    }

    public Family addMembers(List<Person> newMember, int familyId) {
        Family family = familyRepository.getOne(familyId);
        String message = "You have been added to family: " + family.getName();
        for (Person member : newMember) {
            Person person = personRepository.getOne(member.getId());
            family.getMembers().add(person);
            notificationService.createNotification(person, message);
        }
        return familyRepository.save(family);
    }


}
