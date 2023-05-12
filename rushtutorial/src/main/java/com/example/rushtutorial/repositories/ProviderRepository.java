package com.example.rushtutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rushtutorial.entities.ProviderEntity;

public interface ProviderRepository extends JpaRepository<ProviderEntity, Integer> {
}
