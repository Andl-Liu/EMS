package com.example.ems.entity;

import javafx.application.Application;
import javafx.stage.Stage;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="退货单")
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
    private DateTime time;
    @Column
    private DateTime completion_time;
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

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public DateTime getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(DateTime completion_time) {
        this.completion_time = completion_time;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
