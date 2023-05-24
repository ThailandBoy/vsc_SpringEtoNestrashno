package com.example.rushtutorial.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


@Accessors(chain = true)
@Entity
@Table(name = "book_table")
@Getter
@Setter
@ToString
public class BookEntity {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    @Column(name = "name_book")
    private String nameBook;

    @Column(name = "year_created")
    private Integer yearCreated;

    @Column(name = "author_id")
    private Integer authorId;
    
}
