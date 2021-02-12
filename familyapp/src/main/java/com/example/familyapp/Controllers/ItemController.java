package com.example.familyapp.Controllers;

import com.example.familyapp.Beans.Item;
import com.example.familyapp.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/set")
    public Item set(@RequestParam int checkListId, @RequestParam String description) {
        return itemService.set(checkListId, description);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam int id) {
        itemService.delete(id);
    }

    @GetMapping("/markActive")
    public void markActive(@RequestParam int id) {
        itemService.markActive(id);
    }

    @GetMapping("/markInactive")
    public void markInactive(@RequestParam int id) {
        itemService.markInactive(id);
    }

}
