package com.example.familyapp.Utils.Wrappers;

import com.example.familyapp.Beans.Person;
import com.example.familyapp.Utils.Enums.CategoryEnum;

import java.sql.Date;
import java.util.List;

public class ActivityWrapper {
    int id;
    String name;
    String description;
    Date date;
    int personId;
    CategoryEnum category;
    List<Person> participantsToAdd;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public int getPersonId() {
        return personId;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public List<Person> getParticipantsToAdd() {
        return participantsToAdd;
    }
}
