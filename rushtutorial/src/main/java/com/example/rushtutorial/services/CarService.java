package com.example.rushtutorial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.CarEntity;
import com.example.rushtutorial.repositories.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarService {
        
    private final CarRepository carRepository;

    public void save(CarEntity carEntity) {
        carRepository.save(carEntity);
    }

    public void saveAll(List<CarEntity> carList) {
        carRepository.saveAll(carList);
    }

    public Optional<CarEntity> getById(Integer id) {
        return carRepository.findById(id);
    }

    public List<CarEntity> findAll() {
        return carRepository.findAll();
    }

    public List<String> findRedBMWJPQL() {
        return carRepository.findRedBmwJPQL();
    }

    public List<String> findRedBMWSQL() {
        return carRepository.findRedBmwSQL();
    }

    public List<String> findSortJPQL() {
        return carRepository.findAllOrderByJPQL();
    }

    public List<String> findSortSQL() {
        return carRepository.findAllOrderBySQL();
    }
}
