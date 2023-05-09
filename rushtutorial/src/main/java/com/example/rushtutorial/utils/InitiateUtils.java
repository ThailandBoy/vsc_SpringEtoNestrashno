package com.example.rushtutorial.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.FruitEntity;
import com.example.rushtutorial.services.FruitService;

@Service // аннотация помечает бин как сервис
public class InitiateUtils implements CommandLineRunner{ // имплементим интерфейс CommandLineRunner (командная строка запуска)

    private final FruitService fruitService;

    public InitiateUtils (FruitService fruitService) { // create construct to inject bean
        this.fruitService = fruitService;
    }

    // переопределяем метод который позволит
    // выполнять методы нашего приложения при запуске
    @Override
    public void run(String... args) throws Exception {
        System.out.println("run"); // для проверки работы

        List<FruitEntity> fruitEntityList = new ArrayList<>();
        
        // Creation few "Fruit" entities and fill them through setter
        FruitEntity fruitEntity1 = new FruitEntity();
        fruitEntity1.setFruitName("fruit1");
        fruitEntity1.setProviderCode(1);
        
        
        FruitEntity fruitEntity2 = new FruitEntity();
        fruitEntity2.setFruitName("fruit2");
        fruitEntity2.setProviderCode(2);
        

        FruitEntity fruitEntity3 = new FruitEntity();
        fruitEntity3.setFruitName("fruit3");
        fruitEntity3.setProviderCode(3);
        
        

        fruitEntityList.add(fruitEntity1);
        fruitEntityList.add(fruitEntity2);
        fruitEntityList.add(fruitEntity3);
        fruitService.saveAll(fruitEntityList);
        // via service variable call the method to save to DB, one time to every object 
        // fruitService.save(fruitEntity1);
        // fruitService.save(fruitEntity2);
        // fruitService.save(fruitEntity3);



        // get back DB elements
        List<FruitEntity> all = fruitService.getAll();

        // print elements
        for (FruitEntity entity : all) {
            System.out.println(entity);
        }
    }
    
}
