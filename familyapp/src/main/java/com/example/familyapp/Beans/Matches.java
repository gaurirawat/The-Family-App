package com.example.familyapp.Beans;

import com.example.familyapp.Utils.Enums.AcceptanceStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;


@Entity
@JsonRootName("matches")
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "person1Id")
    @JsonIgnoreProperties(value = {"notifications", "activitiesInvolved", "activitiesCreated", "groups", "checklists", "hibernateLazyInitializer"}, allowSetters = true)
    private Person person1;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "person2Id")
    @JsonIgnoreProperties(value = {"notifications", "activitiesInvolved", "activitiesCreated", "groups", "checklists", "hibernateLazyInitializer"}, allowSetters = true)
    private Person person2;

    private String person2details;
    private String remark;
    private AcceptanceStatusEnum status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson1() {
        return person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public String getPerson2details() {
        return person2details;
    }

    public void setPerson2details(String person2details) {
        this.person2details = person2details;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public AcceptanceStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AcceptanceStatusEnum status) {
        this.status = status;
    }

    public Matches() {
    }

    public Matches(String person2details, String remark, AcceptanceStatusEnum status) {
        this.person2details = person2details;
        this.remark = remark;
        this.status = status;
    }
}
