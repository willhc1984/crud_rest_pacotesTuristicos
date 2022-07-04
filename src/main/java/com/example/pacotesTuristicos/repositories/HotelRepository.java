package com.example.pacotesTuristicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pacotesTuristicos.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
