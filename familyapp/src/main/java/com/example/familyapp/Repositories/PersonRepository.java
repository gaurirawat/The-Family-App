package com.example.familyapp.Repositories;

import com.example.familyapp.Beans.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    public Person getByUsernameAndPassword(String userName, String password);
}

