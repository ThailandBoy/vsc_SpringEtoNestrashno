package com.example.rushtutorial.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


@Service // аннотация помечает бин как сервис
public class InitiateUtils implements CommandLineRunner{ // имплементим интерфейс CommandLineRunner (командная строка запуска)

    // переопределяем метод который позволит
    // выполнять методы нашего приложения при запуске
    @Override
    public void run(String... args) throws Exception {
        System.out.println("InitiateUtils run..."); // для проверки работы

        // System.out.println("FruitProviderRun activate!");
        // FruitProviderRun.activate();
        // CarColorRun.activate();

        AuthorBookRun.activate();


    }
    
}
