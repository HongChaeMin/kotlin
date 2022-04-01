package com.example.app.javaObjectEx;

public class Main {
    public static void main(String[] args) {
        Car car = CarFactory.makeCar(10);
        Car car2 = CarFactory.makeCar(20);

        System.out.println(car);
        System.out.println(car2);
        System.out.println(CarFactory.cars.size());
    }
}

