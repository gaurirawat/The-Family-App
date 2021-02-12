package com.example.familyapp.Controllers;

import com.example.familyapp.Beans.Person;
import com.example.familyapp.Repositories.PersonRepository;
import com.example.familyapp.Services.PersonService;
import com.example.familyapp.Utils.Enums.SexEnum;
import com.example.familyapp.Utils.Wrappers.PersonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/get")
    public Person get(@RequestBody PersonWrapper wrapper) {
        Person person =personService.get(wrapper.getUsername(), wrapper.getPassword());
        System.out.println(person == null);
        return person;
    }

    @PostMapping("/getById")
    public Person getById(@RequestBody PersonWrapper wrapper) {
        return personService.getById(wrapper.getId());
    }

    @PostMapping("/set")
    public Person set(@RequestBody PersonWrapper wrapper  ) {
        return personService.set(wrapper.getName(),wrapper.getUsername(), wrapper.getPassword(), wrapper.getContactNo(),
                 wrapper.getEmail(), wrapper.getSex());
    }
}
