package com.example.rushtutorial.repositories;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rushtutorial.entities.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer>{
    
    

    // Кто написал больше всего книг?
    
    // Кто написал какую книгу? SQL
    @Query(
        value = "SELECT author_table.first_nameauthor, author_table.last_nameauthor, book_table.year_created, book_table.name_book FROM book_table JOIN author_table ON book_table.author_id = author_table.id ", 
        nativeQuery = true)
    List<String> authorOfBookSQL();
    
    // Кто написал какую книгу? JPQL
    @Query("SELECT a.firstNameAuthor, a.lastNameAuthor, b.yearCreated, b.nameBook FROM BookEntity b JOIN AuthorEntity a ON b.authorId = a.id")
    List<String> authorOfBookJPQL();
}
