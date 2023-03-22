package com.example.pacotesTuristicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pacotesTuristicos.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
