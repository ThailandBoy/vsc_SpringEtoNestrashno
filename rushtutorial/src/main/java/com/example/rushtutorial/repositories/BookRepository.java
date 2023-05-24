package com.example.rushtutorial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rushtutorial.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{

    // Какая книга написана раньше всех?
    @Query(
        value = "SELECT * FROM book_table ORDER BY year_creat ASC",
        nativeQuery = true
    )
    List<BookEntity> sortByAge();


    // Какие книги были написаны с 1800 по 1900
}   
