package com.example.familyapp.Utils.Wrappers;

import com.example.familyapp.Utils.Enums.SexEnum;

public class PersonWrapper {
    private String name;
    private String username;
    private String password;
    private String contactNo;
    private String email;
    private SexEnum sex;
    private int id;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEmail() {
        return email;
    }

    public SexEnum getSex() {
        return sex;
    }

    public int getId() {
        return id;
    }
}
