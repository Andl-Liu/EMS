package com.example.ems.entity;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="采购申请")
@Table(name="purchase_requisition")
public class Purchase_requisition {
        @Id
        private String id;
        @Column
        private int type;
        @Column
        private DateTime datetime;
        @Column
        private int planner_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public DateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(DateTime datetime) {
        this.datetime = datetime;
    }

    public int getPlanner_id() {
        return planner_id;
    }

    public void setPlanner_id(int planner_id) {
        this.planner_id = planner_id;
    }
}
