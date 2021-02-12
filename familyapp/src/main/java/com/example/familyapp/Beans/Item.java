package com.example.familyapp.Beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;

@Entity
@JsonRootName("item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    private Integer id;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "checklistId")
    @JsonIgnoreProperties(value = { "createdBy", "family", "items", "hibernateLazyInitializer"}, allowSetters = true)
    private Checklist checklist;


    private String description;
    private boolean active = true;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item() {
    }

    public Item(Checklist checklist, String description) {
        this.checklist = checklist;
        this.description = description;
    }
}
