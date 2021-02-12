package com.example.familyapp.Services;

import com.example.familyapp.Beans.*;
import com.example.familyapp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    FamilyRepository familyRepository;
    @Autowired
    ChecklistRepository checklistRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    NotificationService notificationService;

    public Checklist get(int checklistId) {
        return checklistRepository.getOne(checklistId);
    }

    public List<Checklist> getByPersonId(int personId) {
        List<Checklist> list = new ArrayList<>();
        Person person = personRepository.getOne(personId);
        list.addAll(person.getChecklists());
        for (Family family: person.getFamilies()) {
            list.addAll(family.getChecklists());
        }
        return list;
    }

    public Checklist set(String name, boolean isPersonal,  int creatorId, int familyId) {
        Checklist checklist = new Checklist(name, true, isPersonal);
        checklist.setCreatedBy(personRepository.getOne(creatorId));
        if (!isPersonal) {
            Family family = familyRepository.getOne(familyId);
            checklist.setFamily(family);

            String message = "Checklist has ben added to family: " + family.getName();
            for (Person person : family.getMembers()) {
                notificationService.createNotification(person, message);
            }
        }
        return checklistRepository.save(checklist);
    }

}
