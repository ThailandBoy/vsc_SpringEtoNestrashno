package com.example.rushtutorial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rushtutorial.entities.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {

    // покраска БМВ в красный цвет, цена
    @Query("SELECT car.modelName, col.color, col.price FROM CarEntity car, ColorEntity col WHERE car.modelName LIKE 'BMW%' AND col.color LIKE 'Red'")
    List<String> findRedBmwJPQL();

    @Query(
        value = "SELECT car_table.model_name, color_table.color, color_table.price FROM car_table, color_table WHERE car_table.model_name LIKE 'BMW%' AND color_table.color LIKE 'Red'",
        nativeQuery = true
    )
    List<String> findRedBmwSQL();


    // вывод отсортированного списка по алфавиту
    @Query("SELECT e.modelName FROM CarEntity e ORDER BY e.modelName ASC")
    List<String> findAllOrderByJPQL();

    @Query(
        value = "SELECT car_table.model_name FROM car_table ORDER BY car_table.model_name ASC;",
        nativeQuery = true
    )
    List<String> findAllOrderBySQL();
    
}
