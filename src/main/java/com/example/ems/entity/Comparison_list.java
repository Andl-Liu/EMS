package com.example.ems.entity;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="比价单")
@Table(name="comparison")
public class Comparison_list {
    @Id
    private String id;
    @Column
    private int supplier_amount;
    @Column
    private int product_id1;
    @Column
    private int product_id2;
    @Column
    private int product_id3;
    @Column
    private DateTime time;
    @Column
    private DateTime completion_time;
    @Column
    private int purchasera_id;
    @Column
    private int requisition_id;
    @Column
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSupplier_amount() {
        return supplier_amount;
    }

    public void setSupplier_amount(int supplier_amount) {
        this.supplier_amount = supplier_amount;
    }

    public int getProduct_id1() {
        return product_id1;
    }

    public void setProduct_id1(int product_id1) {
        this.product_id1 = product_id1;
    }

    public int getProduct_id2() {
        return product_id2;
    }

    public void setProduct_id2(int product_id2) {
        this.product_id2 = product_id2;
    }

    public int getProduct_id3() {
        return product_id3;
    }

    public void setProduct_id3(int product_id3) {
        this.product_id3 = product_id3;
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

    public int getPurchasera_id() {
        return purchasera_id;
    }

    public void setPurchasera_id(int purchasera_id) {
        this.purchasera_id = purchasera_id;
    }

    public int getRequisition_id() {
        return requisition_id;
    }

    public void setRequisition_id(int requisition_id) {
        this.requisition_id = requisition_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}