package com.example.familyapp.Beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonRootName("checklist")
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    private Integer id;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "familyId")
    @JsonIgnoreProperties(value = {"checklists", "members", "hibernateLazyInitializer"}, allowSetters = true)
    private Family family;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "personId")
    @JsonIgnoreProperties(value = {"notifications", "activitiesInvolved", "activitiesCreated", "families", "checklists", "hibernateLazyInitializer"}, allowSetters = true)
    private Person createdBy;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "checklist")
    @JsonIgnoreProperties(value = {"checklist", "hibernateLazyInitializer"}, allowSetters = true)
    private List<Item> items;


    private String name;
    private boolean isOpen;
    private boolean isPersonal = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isPersonal() {
        return isPersonal;
    }

    public void setPersonal(boolean personal) {
        isPersonal = personal;
    }

    public Checklist() {
    }

    public Checklist(String name, boolean isOpen, boolean isPersonal) {
        this.name = name;
        this.isOpen = isOpen;
        this.isPersonal = isPersonal;
    }
}
