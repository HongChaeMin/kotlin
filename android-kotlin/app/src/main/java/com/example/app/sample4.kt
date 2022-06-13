package com.example.app

// https://kotlinworld.com/166
// https://ko.wikipedia.org/wiki/%EC%8B%B1%EA%B8%80%ED%84%B4_%ED%8C%A8%ED%84%B4
// https://tecoble.techcourse.co.kr/post/2020-11-07-singleton/

// Singleton Pattern
object CarFactory {
    val cars = mutableListOf<Car>()

    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)

        cars.add(car)

        return car
    }
}

data class Car(val horsePower : Int)

fun main() {
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(20)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}