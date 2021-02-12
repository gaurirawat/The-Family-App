package com.example.familyapp.Utils.Wrappers;

import com.example.familyapp.Beans.Person;

import java.util.List;

public class FamilyWrapper {
    private int id;
    private int creatorId;
    private int size;
    private String name;
    private String description;
    private boolean isFamily;
    private List<Person> members;

    public int getId() {
        return id;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFamily() {
        return isFamily;
    }

    public List<Person> getMembers() {
        return members;
    }
}
