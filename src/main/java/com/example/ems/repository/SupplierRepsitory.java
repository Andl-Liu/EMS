package com.example.ems.repository;

import com.example.ems.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepsitory extends JpaRepository <Supplier,Integer> {
}
