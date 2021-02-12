package com.example.familyapp.Controllers;

import com.example.familyapp.Beans.Checklist;
import com.example.familyapp.Services.ChecklistService;
import com.example.familyapp.Utils.Wrappers.ChecklistWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("checklist")
public class ChecklistController {

    @Autowired
    ChecklistService checklistService;

    @PostMapping("/get")
    public Checklist get(@RequestBody ChecklistWrapper wrapper) {
        return checklistService.get(wrapper.getId());
    }

    @PostMapping("/getByPersonId")
    public List<Checklist> getByPersonId(@RequestBody ChecklistWrapper wrapper) {
        return checklistService.getByPersonId(wrapper.getPersonId());
    }

    @PostMapping("/set")
    public Checklist set(@RequestBody ChecklistWrapper wrapper) {
        return checklistService.set(wrapper.getName(), wrapper.isPersonal(),wrapper.getPersonId(), wrapper.getFamilyId());
    }
}
