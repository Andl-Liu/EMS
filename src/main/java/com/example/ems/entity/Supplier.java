package com.example.ems.entity;

import javax.persistence.*;

@Entity
//@Table(name="供应商")
@Table(name="supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String contact;
    @Column
    private String short_code;
    @Column
    private double evaluation;
    @Column
    private String location;
    @Column
    private Boolean valid;
    @Column
    private int cooperation_times;

    public int getCooperation_times() {
        return cooperation_times;
    }

    public void setCooperation_times(int cooperation_times) {
        this.cooperation_times = cooperation_times;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(double evaluation) {
        this.evaluation = evaluation;
    }

    public String getShort_code() {
        return short_code;
    }

    public void setShort_code(String short_code) {
        this.short_code = short_code;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
