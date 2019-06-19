package com.menu.test;

import com.menu.crud.DishService;
import com.menu.entity.Dish;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DishTest {
    DishService dishService = new DishService();

    public void addDish() {
        Dish dish1 = new Dish("Salad", 100.0, 250.00, false);
        Dish dish2 = new Dish("Burger", 120.0, 300.00, false);
        Dish dish3 = new Dish("Desert", 75.0, 100.00, true);
        Dish dish4 = new Dish("WOK", 130.0, 230.00, true);
        dishService.add(dish1);
        dishService.add(dish2);
        dishService.add(dish3);
        dishService.add(dish4);
    }

    public void getAllDishes() {
        List<Dish> dishes = dishService.getAll();
        for (Dish d : dishes) {
            System.out.println(d);
        }
    }


    public void getDishOfPrice() {
        double startPrice = 100.00;
        double endPrice = 120.00;
        List<Dish> dishes = dishService.getAll();
        for (Dish d : dishes) {
            if (d.getPrice() >= startPrice && d.getPrice() <= endPrice)
                System.out.println(d);
        }
    }

    public void getDishOfSale() {
        List<Dish> dishes = dishService.getAll();
        for (Dish d : dishes) {
            if (d.isSale())
                System.out.println(d);
        }
    }

    public void getDishOfWeight() {
        List<Dish> dishes = dishService.getAll();
        List<Dish> dishesOfKilo = new ArrayList<Dish>();
        double weight = 0;
        for (Dish d : dishes) {
            weight += d.getWeight();
            if (weight > 700.0) {
                weight -= d.getWeight();
                break;
            }
            dishesOfKilo.add(d);
        }
        System.out.println(dishesOfKilo.toString());
    }

}
