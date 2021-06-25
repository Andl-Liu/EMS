package com.example.ems.entity;

import javax.persistence.*;

@Entity
//@Table(name="仓库储备表")
@Table(name="Warehouse_inventory_list")
public class Warehouse_inventory_list {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column
    private  Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
