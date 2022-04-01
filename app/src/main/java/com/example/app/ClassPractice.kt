package com.example.app

// java 와 달리 파일 이름과 클래스 이름과 일치 안해도 됨
// 그래서 한 파일 안에 여러 클래스가 있을 수도 있음

// open : 기본적으로 코틀린의 클래스는 파이널 클래스 그래서 상속을 못받음 open 을 붙어주면 됨
open class Human (val name: String = "Anonymous") { // 생성자 (constructor 생략 가능)
    // constructor(name : String) val name = name;

    init {
        // 생성자 실행 동시에 같이 실행됨
        // 처음 인스턴스 생성할 때 하고 싶은 동작을 넣을 수 있음
        println("New human has been born!!");
    }

    constructor(name : String, age : Int) : this(name) { // 주 생성자 선언 필요
        // 부 생성자
        println("my name is $name, $age years old");
    }

    fun eatingCake() {
        println("This is so YUMMYYYYY~~~");
    }

    open fun singASong() { // 오버라이딩 할 때도 open
        println("la la la la");
    }
}

class Korean : Human() { // 상속
    override fun singASong() {
        super.singASong(); // 둘 다 사용 가능
        println("라 라 라 라");
        println("my name is $name");
    }
}

fun main() {
    val human = Human("minHong"); // new 안해도 됨
    val stranger = Human();

    human.eatingCake();

    println("default name is ${stranger.name}");
    println("this human's name is ${human.name}");

    val mom = Human("ChaeMin", 20);

    val korean = Korean();
    korean.singASong();
}