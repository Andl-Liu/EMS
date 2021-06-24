package com.example.ems.entity;

import javax.persistence.*;

@Entity
//@Table(name="用户")
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String account;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private Boolean planner_authority;
    @Column
    private Boolean purchaser_authority;
    @Column
    private Boolean inventory_authority;
    @Column
    private Boolean vaild;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getVaild() {
        return vaild;
    }

    public void setVaild(Boolean vaild) {
        this.vaild = vaild;
    }

    public Boolean getInventory_authority() {
        return inventory_authority;
    }

    public void setInventory_authority(Boolean inventory_authority) {
        this.inventory_authority = inventory_authority;
    }

    public Boolean getPurchaser_authority() {
        return purchaser_authority;
    }

    public void setPurchaser_authority(Boolean purchaser_authority) {
        this.purchaser_authority = purchaser_authority;
    }

    public Boolean getPlanner_authority() {
        return planner_authority;
    }

    public void setPlanner_authority(Boolean planner_authority) {
        this.planner_authority = planner_authority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
