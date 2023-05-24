package com.example.rushtutorial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.ColorEntity;
import com.example.rushtutorial.repositories.ColorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorService {
    
    private final ColorRepository colorRepository;


    public void save(ColorEntity colorEntity) {
        colorRepository.save(colorEntity);
    }

    public void saveAll(List<ColorEntity> colorList) {
        colorRepository.saveAll(colorList);
    }

    public Optional<ColorEntity> findById(Integer id) {
        return colorRepository.findById(id);
    }

    public List<ColorEntity> findAll() {
        return colorRepository.findAll();
    }

    public List<String> findMaxOrderByJPQL(){
        return colorRepository.findMaxOrderByJPQL();
    }
}
