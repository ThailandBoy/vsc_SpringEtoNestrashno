package com.example.rushtutorial.entities;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true) // зачем она нужна увидим позже
@ToString
@Getter // generated getters by lombok
@Setter // generated setters by lombok
@Entity // annotation to mark the class as a "entity"
@Table(name = "provider_table")
public class ProviderEntity {

    @Id
    @Column(name = "id_provider")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    @Column(name = "provider_name")
    private String providerName;
    
}
