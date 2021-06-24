package com.example.ems.entity;

import javax.persistence.*;

@Entity
//@Table(name="采购信息")
@Table(name="purchase_information")
public class Purchase_information {
   @Id
   @Column(length=22)
   private String id;
   @Column
   private String requisition_id;
   @Column
   private String name;
   @Column
   private String specification;
   @Column
   private Double amount;
   @Column
   private String unit;
   @Column
   private String order_id;

   public String getOrder_id() {
      return order_id;
   }

   public void setOrder_id(String order_id) {
      this.order_id = order_id;
   }

   public String getUnit() {
      return unit;
   }

   public void setUnit(String unit) {
      this.unit = unit;
   }

   public Double getAmount() {
      return amount;
   }

   public void setAmount(Double amount) {
      this.amount = amount;
   }

   public String getSpecification() {
      return specification;
   }

   public void setSpecification(String specification) {
      this.specification = specification;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getRequisition_id() {
      return requisition_id;
   }

   public void setRequisition_id(String requisition_id) {
      this.requisition_id = requisition_id;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }
}
