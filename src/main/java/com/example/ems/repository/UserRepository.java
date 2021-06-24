package com.example.ems.repository;

import com.example.ems.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}
