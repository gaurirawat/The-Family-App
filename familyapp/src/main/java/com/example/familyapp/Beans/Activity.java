package com.example.familyapp.Beans;

import com.example.familyapp.Utils.Enums.ActivityTypeEnum;
import com.example.familyapp.Utils.Enums.CategoryEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@JsonRootName("activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "personId")
    @JsonIgnoreProperties(value = {"activitiesCreated", "activitiesInvolved", "hibernateLazyInitializer"}, allowSetters = true)
    private Person createdBy;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "activitiesInvolved")
    @JsonIgnoreProperties(value = {"activitiesInvolved", "activitiesCreated", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Person> participants;

    private String name;
    private String description;
    private Date date;

    @Enumerated(EnumType.STRING)
    private ActivityTypeEnum type;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum categoryEnum) {
        this.category = categoryEnum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Person> participants) {
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ActivityTypeEnum getType() {
        return type;
    }

    public void setType(ActivityTypeEnum type) {
        this.type = type;
    }

    public Activity() {
    }

    public Activity(String name, String description, Date date, ActivityTypeEnum type, CategoryEnum category) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.date = date;
        this.category = category;
    }
}
