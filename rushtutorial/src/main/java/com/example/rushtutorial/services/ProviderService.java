package com.example.rushtutorial.services;


import java.util.List;

import com.example.rushtutorial.entities.ProviderEntity;
import com.example.rushtutorial.repositories.ProviderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;

    public void save(ProviderEntity providerEntity) {
        providerRepository.save(providerEntity);
    }

    public void saveAll(List<ProviderEntity> providerEntitiesList) {
        providerRepository.saveAllAndFlush(providerEntitiesList);
    }

    public List<ProviderEntity> getAll() {
        return providerRepository.findAll();
    }


}
