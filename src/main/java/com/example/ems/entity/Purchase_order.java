package com.example.ems.entity;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="采购单")
@Table(name="purchase_order")
public class Purchase_order {
    @Id
    private String id;
    @Column
    private DateTime time;
    @Column
    private int purchaser_id;
    @Column
    private DateTime completion_time;
    @Column
    private Boolean material;
    @Column
    private int evaluation;
    @Column
    private int supplier_id;
    @Column
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public int getPurchaser_id() {
        return purchaser_id;
    }

    public void setPurchaser_id(int purchaser_id) {
        this.purchaser_id = purchaser_id;
    }

    public DateTime getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(DateTime completion_time) {
        this.completion_time = completion_time;
    }

    public Boolean getMaterial() {
        return material;
    }

    public void setMaterial(Boolean material) {
        this.material = material;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
