package com.example.ems.entity;

import javafx.application.Application;
import javafx.stage.Stage;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name="้่ดงๅ")
@Table(name="return_form")
public class Return_form  {
    @Id
    private String id;
    @Column
    private int inventory_id;
    @Column
    private int product_id;
    @Column
    private Double amount;
    @Column
    private Date time;
    @Column
    private Date completion_time;
    @Column
    private Boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(Date completion_time) {
        this.completion_time = completion_time;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }




}
