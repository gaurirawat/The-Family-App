package com.example.familyapp.Controllers;

import com.example.familyapp.Beans.Notification;
import com.example.familyapp.Services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping("/read")
    public void markRead(@RequestParam int id) {
        notificationService.markRead(id);
    }

    @GetMapping("/getByPersonId")
    public List<Notification> getByPersonId(@RequestParam int personId) {
        return notificationService.getByPersonId(personId);
    }
}
