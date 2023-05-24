package com.example.rushtutorial.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rushtutorial.entities.CarEntity;
import com.example.rushtutorial.entities.ColorEntity;
import com.example.rushtutorial.services.CarService;
import com.example.rushtutorial.services.ColorService;



@Service
public class CarColorRun {

    private static CarService carService;
    private static ColorService colorService;

    public CarColorRun(CarService carService, ColorService colorService) {
        this.carService = carService;
        this.colorService = colorService;
    }

    public static void activate() {
        
        System.out.println("Car - Color activated!");

        List<CarEntity> carList = new ArrayList<>(
            Arrays.asList(
                new CarEntity().setModelName("LADA Granta").setColor("Black"),
                new CarEntity().setModelName("LADA Vesta").setColor("White"),
                new CarEntity().setModelName("LADA Largus").setColor("Grey"),
                new CarEntity().setModelName("LADA 4x4").setColor("Blue"),
                new CarEntity().setModelName("LADA Niva").setColor("Yellow"),
                new CarEntity().setModelName("BMW 1").setColor("Black"),
                new CarEntity().setModelName("BMW i7").setColor("White"),
                new CarEntity().setModelName("BMW 8").setColor("Grey"),
                new CarEntity().setModelName("BMW X1").setColor("Blue"),
                new CarEntity().setModelName("BMW iX").setColor("Yellow"),
                new CarEntity().setModelName("AUDI S1").setColor("Black"),
                new CarEntity().setModelName("AUDI S2").setColor("White"),
                new CarEntity().setModelName("AUDI SQ2").setColor("Grey"),
                new CarEntity().setModelName("AUDI RS 2 Avant").setColor("Blue"),
                new CarEntity().setModelName("AUDI TT RS").setColor("Yellow")
            )
        );
        carService.saveAll(carList);

        List<ColorEntity> colorList = new ArrayList<>(
            Arrays.asList(
                new ColorEntity().setColor("Black").setPrice(500),
                new ColorEntity().setColor("White").setPrice(436),
                new ColorEntity().setColor("Grey").setPrice(773),
                new ColorEntity().setColor("Blue").setPrice(633),
                new ColorEntity().setColor("Yellow").setPrice(650),
                new ColorEntity().setColor("Red").setPrice(743)
            )
        );
        colorService.saveAll(colorList);

        // System.out.println("Сколько стоит покраска");
        // for (String carString : carService.findRedBMWJPQL()) {
        //     System.out.println(carString);
        // }

        // System.out.println("Sort by alphabet");
        // for (String carEntity : carService.findSortJPQL()) {
        //     System.out.println(carEntity);
        // }

        System.out.println("Sort by max to min");
        for (String color : colorService.findMaxOrderByJPQL()) {
            System.out.println(color);
        }

        

    }
}
