package com.example.rushtutorial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rushtutorial.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{

    // Какая книга написана раньше всех? SQL
    @Query(
        value = "SELECT book_table.year_created, book_table.name_book FROM book_table ORDER BY book_table.year_created ASC",
        nativeQuery = true
    )
    List<String> sortByAgeSQL();

    // Какая книга написана раньше всех? JPQL
    @Query("SELECT b.yearCreated, b.nameBook FROM BookEntity b ORDER BY b.yearCreated ASC")
    List<String> sortByAgeJPQL();


    // Какие книги были написаны с 1800 по 1900 SQL
    @Query( 
        value = "SELECT * FROM book_table WHERE book_table.year_created BETWEEN 1800 AND 1900 ORDER BY book_table.year_created ASC",
        nativeQuery = true
    )
    List<BookEntity> between1819_SQL();

     // Какие книги были написаны с 1800 по 1900 JPQL
     @Query("SELECT b FROM BookEntity b WHERE b.yearCreated BETWEEN 1800 AND 1900 ORDER BY b.yearCreated ASC")
    List<BookEntity> between1819_JPQL();
}   
