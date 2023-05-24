package com.example.rushtutorial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.AuthorEntity;
import com.example.rushtutorial.repositories.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorService {
    
    private final AuthorRepository authorRepository;

    public void save(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }

    public void saveAll(List<AuthorEntity> authList) {
        authorRepository.saveAll(authList);
    }

    public Optional<AuthorEntity> findById(Integer id) {
        return authorRepository.findById(id);
    }

    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }

    // Who write a book? SQP
    public List<String> authorOfBookSQL() {
        return authorRepository.authorOfBookSQL();
    }

    // // Who write a book? JPQP
    public List<String> authorOfBookJPQL() {
        return authorRepository.authorOfBookJPQL();
    }
    // Кто написал больше всего книг?

}
