package com.example.familyapp.Beans;

import com.example.familyapp.Utils.Enums.NotificationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@JsonRootName("notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    private Integer id;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "personId")
    @JsonIgnoreProperties(value = {"notifications", "activitiesInvolved", "activitiesCreated", "families", "checklists", "hibernateLazyInitializer"}, allowSetters = true)
    private Person person;

    private String message;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private boolean notificationRead;


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isNotificationRead() {
        return notificationRead;
    }

    public void setNotificationRead(boolean notificationRead) {
        this.notificationRead = notificationRead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Notification() {
    }

    public Notification(String message, Person person) {
        this.message = message;
        this.person = person;
        this.notificationRead = false;
    }
}
