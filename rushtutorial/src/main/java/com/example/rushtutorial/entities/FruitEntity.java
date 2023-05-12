package com.example.rushtutorial.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // аннотация сгенерирует при компиляции необходимый код
@Entity // помечаем бин как сущность
@Table(name = "fruit_table") // в этой аннотации можно указать имя создаваемой таблицы
public class FruitEntity {

    @Id // аннотация из пакета jakarta.persistence.*, помечает поле как id
    @Column(name = "id_fruit") // в этой аннотации можно указать имя поля
    @GenericGenerator(name = "generator", strategy = "increment") // незаметно добрались до hibernate,
        // здесь указывается что id будет автоматически увеличиваться при новых записях 
    @GeneratedValue(generator = "generator")// аннотация генерации id
    private Integer id;

    @Column(name = "fruit_name")
    private String fruitName;

    @Column(name = "provider_code")
    private Integer providerCode;

    // что бы с классом можно было совершать манипуляции создается
    // пустой конструктор, геттеры, сеттеры и переопр. метод toString()
    // public FruitEntity(){}

    // // геттеры, сеттеры
    // public Integer getId() {
    //     return this.id;
    // }

    // public String getFruitName() {
    //     return this.fruitName;
    // }

    // public void setFruitName(String fruitName) {
    //     this.fruitName = fruitName;
    // }

    // public Integer getProviderCode() {
    //     return this.providerCode;
    // }

    // public void setProviderCode(Integer providerCode) {
    //     this.providerCode = providerCode;
    // }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fruitName='" + getFruitName() + "'" +
            ", providerCode='" + getProviderCode() + "'" +
            "}";
    }


}
