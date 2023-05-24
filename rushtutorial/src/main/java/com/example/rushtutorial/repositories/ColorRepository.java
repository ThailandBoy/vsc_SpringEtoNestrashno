package com.example.rushtutorial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rushtutorial.entities.ColorEntity;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity, Integer> {

    // Какой цвет самый дорогой
    @Query("SELECT e.color, e.price FROM ColorEntity e ORDER BY e.price DESC")
    List<String> findMaxOrderByJPQL();
    
}
