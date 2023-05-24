package com.example.rushtutorial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.BookEntity;
import com.example.rushtutorial.repositories.BookRepository;


@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    public void saveAll(List<BookEntity> bookEntities) {
        bookRepository.saveAll(bookEntities);
    }

    public Optional<BookEntity> findById(Integer id) {
        return bookRepository.findById(id);
    }

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    // Какая книга написана раньше всех? SQL
    public List<String> sortByAgeSQL() {
        return bookRepository.sortByAgeSQL();
    }
    
    // Какая книга написана раньше всех? JPQL
    public List<String> sortByAgeJPQL() {
        return bookRepository.sortByAgeJPQL();
    }

    // Какие книги были написаны с 1800 по 1900 SQL
    public List<BookEntity> between1819_SQL() {
        return bookRepository.between1819_SQL();
    }

    // Какие книги были написаны с 1800 по 1900 JPQL
    public List<BookEntity> between1819_JPQL() {
        return bookRepository.between1819_JPQL();
    }

}
