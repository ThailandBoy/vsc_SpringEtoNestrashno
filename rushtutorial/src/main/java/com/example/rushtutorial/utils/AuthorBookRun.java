package com.example.rushtutorial.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.AuthorEntity;
import com.example.rushtutorial.entities.BookEntity;
import com.example.rushtutorial.services.AuthorService;
import com.example.rushtutorial.services.BookService;


@Service
public class AuthorBookRun {
    private static AuthorService authorService;
    private static BookService bookService;


    public AuthorBookRun(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }


    public static void activate() {

        System.out.println("AuthorBookRun activated!");

        List<AuthorEntity> authList = new ArrayList<>(
            Arrays.asList(
                new AuthorEntity().setFirstNameAuthor("Александр").setLastNameAuthor("Грибоедов"),
                new AuthorEntity().setFirstNameAuthor("Лев").setLastNameAuthor("Толстой"),
                new AuthorEntity().setFirstNameAuthor("Михаил").setLastNameAuthor("Лермонтов"),
                new AuthorEntity().setFirstNameAuthor("Александр").setLastNameAuthor("Пушкин"),
                new AuthorEntity().setFirstNameAuthor("Джоан").setLastNameAuthor("Роулинг")
            )
        );
        authorService.saveAll(authList);

        List<BookEntity> bookList = new ArrayList<>(
            Arrays.asList(
                new BookEntity().setNameBook("Горе от ума").setYearCreated(1824).setAuthorId(1),
                new BookEntity().setNameBook("Война и мир").setYearCreated(1863).setAuthorId(2),
                new BookEntity().setNameBook("Мцыри").setYearCreated(1838).setAuthorId(3),
                new BookEntity().setNameBook("Евгений Онегин").setYearCreated(1833).setAuthorId(4),
                new BookEntity().setNameBook("Гарри Поттер и философский камень").setYearCreated(1997).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и тайная комната").setYearCreated(1998).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и узник азкабана").setYearCreated(1999).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и кубок огня").setYearCreated(2000).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и орден феникса").setYearCreated(2003).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и Философский камень").setYearCreated(1997).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и дары смерти").setYearCreated(2007).setAuthorId(5),
                new BookEntity().setNameBook("Анна Каренина").setYearCreated(1877).setAuthorId(2),
                new BookEntity().setNameBook("Герой нашего времени").setYearCreated(1840).setAuthorId(3),
                new BookEntity().setNameBook("Бородино").setYearCreated(1837).setAuthorId(3),
                new BookEntity().setNameBook("Капитанская дочь").setYearCreated(1836).setAuthorId(4),
                new BookEntity().setNameBook("Дубровский").setYearCreated(1841).setAuthorId(4),
                new BookEntity().setNameBook("Сказка мертвой принцессы и семи рыцарей").setYearCreated(1833).setAuthorId(4)
            )
        );

        bookService.saveAll(bookList);


        // System.out.println("Sort by creation age. SQL");
        // for (String bookEntity : bookService.sortByAgeSQL()) {
        //     System.out.println(bookEntity);
        // }

        // System.out.println("Sort by creation age. JPQL");
        // for (String bookString : bookService.sortByAgeJPQL()) {
        //     System.out.println(bookString);            
        // }

        // System.out.println("Авторы книг SQL:");
        // for (String authorBook : authorService.authorOfBookSQL()) {
        //     System.out.println(authorBook);
        // }

        // System.out.println("Авторы книг JPQL:");
        // for (String authorBook : authorService.authorOfBookJPQL()) {
        //     System.out.println(authorBook);
        // }

        // System.out.println("Creation year between 1800 - 1900 SQL");
        // for (BookEntity bookEntity : bookService.between1819_SQL()) {
        //     System.out.println(bookEntity);
        // }

        // System.out.println("Creation year between 1800 - 1900 JPQL");
        // for (BookEntity bookEntity : bookService.between1819_JPQL()) {
        //     System.out.println(bookEntity);
        // }

        System.out.println("Book count by Author: SQL");
        for (String bookString : authorService.bookCountByAuthorSQL()) {
            System.out.println(bookString);
        }

        System.out.println("Book count by Author: JPQL");
        for (String bookString : authorService.bookCountByAuthorJPQL()) {
            System.out.println(bookString);
        }

    }
}
