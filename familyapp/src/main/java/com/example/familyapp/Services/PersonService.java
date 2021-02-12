package com.example.familyapp.Services;

import com.example.familyapp.Beans.Person;
import com.example.familyapp.Repositories.FamilyRepository;
import com.example.familyapp.Repositories.PersonRepository;
import com.example.familyapp.Utils.Enums.SexEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    FamilyRepository familyRepository;

    public Person get(String username, String password) {
        return personRepository.getByUsernameAndPassword(username, password);
    }

    public Person getById(int id) {
        return personRepository.getOne(id);
    }
    public Person set(String name, String username, String password, String contactNo, String email, SexEnum sex) {
        Person person = new Person(name, username, password, contactNo, email, sex);
        return personRepository.save(person);
    }
}
