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
                new BookEntity().setNameBook("Горе от ума").setYearCreat(1824).setAuthorId(1),
                new BookEntity().setNameBook("Война и мир").setYearCreat(1863).setAuthorId(2),
                new BookEntity().setNameBook("Мцыри").setYearCreat(1838).setAuthorId(3),
                new BookEntity().setNameBook("Евгений Онегин").setYearCreat(1833).setAuthorId(4),
                new BookEntity().setNameBook("Гарри Поттер и философский камень").setYearCreat(1997).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и тайная комната").setYearCreat(1998).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и узник азкабана").setYearCreat(1999).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и кубок огня").setYearCreat(2000).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и орден феникса").setYearCreat(2003).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и Философский камень").setYearCreat(1997).setAuthorId(5),
                new BookEntity().setNameBook("Гарри Поттер и дары смерти").setYearCreat(2007).setAuthorId(5),
                new BookEntity().setNameBook("Анна Каренина").setYearCreat(1877).setAuthorId(2),
                new BookEntity().setNameBook("Герой нашего времени").setYearCreat(1840).setAuthorId(3),
                new BookEntity().setNameBook("Бородино").setYearCreat(1837).setAuthorId(3),
                new BookEntity().setNameBook("Капитанская дочь").setYearCreat(1836).setAuthorId(4),
                new BookEntity().setNameBook("Дубровский").setYearCreat(1841).setAuthorId(4),
                new BookEntity().setNameBook("Сказка мертвой принцессы и семи рыцарей").setYearCreat(1833).setAuthorId(4)
            )
        );

        bookService.saveAll(bookList);


        System.out.println("Sort by creation age.");
        for (BookEntity bookEntity : bookService.sortByAge()) {
            System.out.println(bookEntity);
        }

        System.out.println("Авторы книг SQL:");
        for (String authorBook : authorService.authorOfBookSQL()) {
            System.out.println(authorBook);
        }

        System.out.println("Авторы книг JPQL:");
        for (String authorBook : authorService.authorOfBookJPQL()) {
            System.out.println(authorBook);
        }

    }
}
