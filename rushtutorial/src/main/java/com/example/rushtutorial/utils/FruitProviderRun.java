package com.example.rushtutorial.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.FruitEntity;
import com.example.rushtutorial.entities.ProviderEntity;
import com.example.rushtutorial.services.FruitService;
import com.example.rushtutorial.services.ProviderService;


@Service
public class FruitProviderRun {
    private static FruitService fruitService;
    private static ProviderService providerService;

    public FruitProviderRun (){
        fruitService = new FruitService(null);
        providerService = new ProviderService(null);
    }

    public static void activate() {
        System.out.println("Fruit - Provider activated"); // для проверки работы

        // код ниже благодаря @Accessors(chain = true) мы можем заполнить (проинициализировать) List следующий образом:
        List<FruitEntity> fruitEntityList = new ArrayList<>(    // тут создаем обычный ArrayList
                        Arrays.asList(           // здесь мы создаем обертку, которае превращает список объектов FruitEntity в List 
                            new FruitEntity()    // создаем экземпляр класса FruitEntity
                                .setFruitName("Fruit1") // через сеттеры заполняем поля сущности
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                            new FruitEntity()
                                .setFruitName("Fruit2")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                            new FruitEntity()
                                .setFruitName("Fruit3")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                            new FruitEntity()
                                .setFruitName("Fruit4")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                            new FruitEntity()
                                .setFruitName("Fruit5")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                            new FruitEntity()
                                .setFruitName("Fruit6")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                            new FruitEntity()
                                .setFruitName("Fruit7")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                            new FruitEntity()
                                .setFruitName("Fruit8")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                            new FruitEntity()
                                .setFruitName("Fruit9")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10))
                        )
        );

        List<ProviderEntity> providerList = new ArrayList<>(
            Arrays.asList(
                new ProviderEntity().setProviderName("Provider1"),
                new ProviderEntity().setProviderName("Provider2"),
                new ProviderEntity().setProviderName("Provider3"),
                new ProviderEntity().setProviderName("Provider4"),
                new ProviderEntity().setProviderName("Provider5")
            )
        );

        fruitService.saveAll(fruitEntityList);// сохраняем List фруктов

        System.out.println("\nТаблица фруктов");
        for (FruitEntity fruitEntity : fruitService.getAll()) {
            System.out.println(fruitEntity);
        }

        providerService.saveAll(providerList);
        
        System.out.println("\nТаблица поставщиков");
        for (ProviderEntity providerEntity : providerService.getAll()) {
            System.out.println(providerEntity);
        }


        System.out.println("\nЗапуск метода between");
        for (FruitEntity fruitEntity : fruitService.between(5, 7)) {
            System.out.println(fruitEntity);
        }

        System.out.println("\nТаблица фруктов и их поставщиков");
        for (String fruitEntity : fruitService.joinString()) {
            System.out.println(fruitEntity);
        }

        System.out.println("\nТаблица фруктов и их поставщиков");
        for (FruitEntity fruitEntity : fruitService.joinFruit()) {
            System.out.println(fruitEntity);
        }

        System.out.println("\nТаблица фруктов и их поставщиков");
        for (String fruitString : fruitService.joinSqlFruit()) {
            System.out.println(fruitString);
        }

        System.out.println("\nВызов кастомного запроса:");
        for (FruitEntity fruitEntity : fruitService.getAllFruitName()) {
            System.out.println(fruitEntity);
        }


        // без @Accessors(chain = true) это было бы так
        // List<FruitEntity> fruit = new ArrayList<>();
        //         FruitEntity fruitEntity = new FruitEntity();
        //         fruitEntity.setFruitName("Fruit Without Accessor");
        //         fruitEntity.setProviderCode(88);
        
        
        // Creation few "Fruit" entities and fill them through setter
        // FruitEntity fruitEntity1 = new FruitEntity();
        // fruitEntity1.setFruitName("fruit1");
        // fruitEntity1.setProviderCode(1);
        
        
        // FruitEntity fruitEntity2 = new FruitEntity();
        // fruitEntity2.setFruitName("fruit2");
        // fruitEntity2.setProviderCode(2);
        

        // FruitEntity fruitEntity3 = new FruitEntity();
        // fruitEntity3.setFruitName("fruit3");
        // fruitEntity3.setProviderCode(3);
        

        // List<FruitEntity> fruitEntityList = new ArrayList<>();
        // fruitEntityList.add(fruitEntity1);
        // fruitEntityList.add(fruitEntity2);
        // fruitEntityList.add(fruitEntity3);
        // fruitService.saveAll(fruitEntityList);


        // via service variable call the method to save to DB, one time to every object 
        // fruitService.save(fruitEntity1);
        // fruitService.save(fruitEntity2);
        // fruitService.save(fruitEntity3);



        // get back DB elements
        // List<FruitEntity> all = fruitService.getAll();

        // // print elements
        // for (FruitEntity entity : all) {
        //     System.out.println(entity);
        // }
    }
}
