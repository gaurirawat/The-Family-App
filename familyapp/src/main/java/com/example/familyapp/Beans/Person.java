package com.example.familyapp.Beans;

import com.example.familyapp.Utils.Enums.MaritalStatusEnum;
import com.example.familyapp.Utils.Enums.SexEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@JsonRootName("person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    private Integer id;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "person_activity_mapping", joinColumns = @JoinColumn(name = "personId"), inverseJoinColumns = @JoinColumn(name = "activityId"))
    @JsonIgnoreProperties(value = {"participants", "createdBy", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Activity> activitiesInvolved;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "person_family_mapping", joinColumns = @JoinColumn(name = "personId"), inverseJoinColumns = @JoinColumn(name = "familyId"))
    @JsonIgnoreProperties(value = {"members", "checklist", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Family> families;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "createdBy")
    @JsonIgnoreProperties(value = {"createdBy", "participants","hibernateLazyInitializer"}, allowSetters = true)
    private List<Activity> activitiesCreated;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    @JsonIgnoreProperties(value = {"person", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Notification> notifications;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "createdBy")
    @JsonIgnoreProperties(value = { "createdBy", "family", "items", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Checklist> checklists;


    @Column(nullable = false)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
    private Date dob = null;

    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    @Enumerated(EnumType.STRING)
    private MaritalStatusEnum maritalStatus = MaritalStatusEnum.SINGLE;

    private String username;
    private String password;
    private String contactNo;
    private String email;
    private int newNotifications = 0;
    private boolean IsAvailableForMarriage = false;
    private boolean isAlive = true;

    public int getNewNotifications() {
        return newNotifications;
    }

    public void setNewNotifications(int newNotifications) {
        this.newNotifications = newNotifications;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Activity> getActivitiesInvolved() {
        return activitiesInvolved;
    }

    public void setActivitiesInvolved(List<Activity> activitiesInvolved) {
        this.activitiesInvolved = activitiesInvolved;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }

    public List<Activity> getActivitiesCreated() {
        return activitiesCreated;
    }

    public void setActivitiesCreated(List<Activity> activitiesCreated) {
        this.activitiesCreated = activitiesCreated;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Checklist> getChecklists() {
        return checklists;
    }

    public void setChecklists(List<Checklist> checklists) {
        this.checklists = checklists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MaritalStatusEnum getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatusEnum maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public boolean isAvailableForMarriage() {
        return IsAvailableForMarriage;
    }

    public void setAvailableForMarriage(boolean availableForMarriage) {
        IsAvailableForMarriage = availableForMarriage;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Person() {
    }

    public Person(String name, String username, String password, String contactNo, String email, SexEnum sex) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.contactNo = contactNo;
        this.email = email;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", sex=" + sex +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", maritalStatus=" + maritalStatus +
                ", IsAvailableForMarriage=" + IsAvailableForMarriage +
                ", isAlive=" + isAlive +
                '}';
    }
}
