package com.example.familyapp.Utils.Wrappers;

import com.example.familyapp.Beans.Item;

import java.util.List;

public class ChecklistWrapper {
    int id;
    int familyId;
    int personId;
    boolean isPersonal;
    String name;
    List<Item> items;

    public int getId() {
        return id;
    }

    public int getFamilyId() {
        return familyId;
    }

    public int getPersonId() {
        return personId;
    }

    public boolean isPersonal() {
        return isPersonal;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }
}
