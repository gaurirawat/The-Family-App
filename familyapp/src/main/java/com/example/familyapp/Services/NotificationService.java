package com.example.familyapp.Services;

import com.example.familyapp.Beans.Notification;
import com.example.familyapp.Beans.Person;
import com.example.familyapp.Repositories.NotificationRepository;
import com.example.familyapp.Repositories.PersonRepository;
import com.example.familyapp.Utils.Enums.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    PersonRepository personRepository;

    public void markRead(int id) {
        Notification notification = notificationRepository.getOne(id);
        notification.setNotificationRead(true);
        notificationRepository.save(notification);
    }

    public List<Notification> getByPersonId(int personId) {
        List<Notification> notifications = notificationRepository.getByPerson_Id(personId);
        Collections.sort(notifications, Comparator.comparing(Notification::getTimestamp));
        Collections.reverse(notifications);
        return notifications;
    }

    public void createNotification(Person person, String message) {
        person.setNewNotifications(person.getNewNotifications()+ 1);
        Notification notification = new Notification(message, person);
        notificationRepository.save(notification);
    }
}
