package com.example.rushtutorial.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@Data
public class BookValueEntity {
    
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    Integer id;
    String nameBook;
    String firstNameAuthor;
    String lastNameAuthor;
    Integer yearCreated;
}
