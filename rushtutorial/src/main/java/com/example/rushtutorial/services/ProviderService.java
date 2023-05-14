package com.example.rushtutorial.services;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.FruitEntity;
import com.example.rushtutorial.entities.ProviderEntity;
import com.example.rushtutorial.repositories.ProviderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;

    public void save(ProviderEntity providerEntity) {
        providerRepository.save(providerEntity);
    }

    public void saveAll(List<ProviderEntity> providerEntitiesList) {
        providerRepository.saveAll(providerEntitiesList);
    }

    public List<ProviderEntity> getAll() {
        return providerRepository.findAll();
    }

    public Optional<ProviderEntity> getById(Integer id) {
        return providerRepository.findById(id);
    }

    public void deleteById(Integer id) {
        providerRepository.deleteById(id);
    }

    public Boolean exist(Example<? extends ProviderEntity> example) {
        return providerRepository.exists(example);
    }


}
