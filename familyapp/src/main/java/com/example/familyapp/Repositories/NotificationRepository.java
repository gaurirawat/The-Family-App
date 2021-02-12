package com.example.familyapp.Repositories;

import com.example.familyapp.Beans.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    public List<Notification> getByPerson_Id(int personId);
}

