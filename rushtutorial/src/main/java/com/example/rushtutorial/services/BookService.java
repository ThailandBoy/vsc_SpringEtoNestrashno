package com.example.rushtutorial.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.BookEntity;
import com.example.rushtutorial.entities.BookValueEntity;
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

    // JOIN BOOK STRING
    public List<String> joinBookString() {
        return bookRepository.joinBookString();
    }

    // JOIN BOOK STRING
    public List<Object[]> joinBookObj() {
        return bookRepository.joinBookObj();
    }

    // First Mapping
    public List<BookValueEntity> bookValueEntities() {

        // положим ответ от БД в переменную с типом List<Object[]>
        List<Object[]> objects = bookRepository.joinBookObj();

        // создаем лист конечных объектов
        List<BookValueEntity> bookValueEntities = new ArrayList<>();

        objects // берем переменную типа List<Object[]> (Лист массивов Object-ов), с ответом от БД
            .stream() // превращаем List<Object[]> из массива object-ов в стрим
            .forEach( // forEach - терминальный оператор, выполняет указанное действие для каждого элемента стрима
                // дальше идет лямбда, она говорит фор ичу - что делать для каждого элемента стрима
                (obj) -> // объявляем(называем) переменную "obj" ей будут присваиваться объекты стрима (массивы Object - ов)
                {// так как запись в лямбде у нас в несколько строк, ставим {}
                    bookValueEntities.add( // фор ич возьмет "obj" и добавит в List<BookValue>, предварительно сделав маппинг
                        new BookValueEntity() // создаем объект BookValueEntity
                            // ниже происходит собственно "маппинг"
                            // поля(элементы) "obj" записываются в соответствующие поля созданного BookValueEntity
                            // так как поле "obj" имеет тип Object необходимо его привести к типу поля объекта BookValueEntity т.е. String
                            .setNameBook((String) obj[0])
                            .setFirstNameAuthor((String) obj[1])
                            .setLastNameAuthor((String) obj[2])
                            .setYearCreated((Integer) obj[3])
                    );

                } 

            );
        return bookValueEntities;
    }

}
