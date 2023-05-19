package com.example.rushtutorial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rushtutorial.entities.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    List<CarEntity> findAll();
}
