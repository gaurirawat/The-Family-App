package com.example.familyapp.Beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@JsonRootName("family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    private Integer id;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "families")
    @JsonIgnoreProperties(value = {"notifications", "activitiesInvolved", "activitiesCreated", "families", "checklists", "activitiesCreated", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Person> members;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "family")
    @JsonIgnoreProperties(value = {"family", "createdBy", "items","hibernateLazyInitializer"}, allowSetters = true)
    private List<Checklist> checklists;


    @Column(nullable = false)
    private String name;
    private String description = null;
    private int size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Family() {
    }

    public Family(String name, int size, String description, boolean isFamily) {
        this.name = name;
        this.size = size;
        this.description = description;
    }
}
