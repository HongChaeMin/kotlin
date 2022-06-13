package com.example.app.javaObjectEx;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> cars;

    public static Car makeCar(int horsePower) {
        cars = cars == null ? new ArrayList<>() : cars;
        Car car = new Car(horsePower);

        cars.add(car);

        return car;
    }

}
