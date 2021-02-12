package com.example.familyapp.Controllers;

import com.example.familyapp.Beans.Family;
import com.example.familyapp.Beans.Person;
import com.example.familyapp.Services.FamilyService;
import com.example.familyapp.Services.PersonService;
import com.example.familyapp.Utils.Wrappers.FamilyWrapper;
import com.example.familyapp.Utils.Wrappers.PersonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("family")
public class FamilyController {

    @Autowired
    FamilyService familyService;

    @PostMapping("/get")
    public Family get(@RequestBody FamilyWrapper wrapper) {
        return familyService.get(wrapper.getId());
    }

    @PostMapping("/create")
    public Family createFamily(@RequestBody FamilyWrapper wrapper) {
        return familyService.createFamily(wrapper.getName(), wrapper.getDescription(), wrapper.getMembers(), wrapper.getCreatorId());
    }

    @PostMapping("/addMembers")
    public Family addMembers(@RequestBody FamilyWrapper wrapper) {
        return familyService.addMembers(wrapper.getMembers(), wrapper.getId());
    }

}
