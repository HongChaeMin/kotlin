package com.example.app

fun main() {

    // 3. String Template

    val name = "minHong";
    val lastName = "chae";
    println("my name is $name I'm 20"); // 오오오오오~~~~
    println("my name is ${name}I'm 20"); // ohohohohohoohhohohoh~~~~
    println("my name is ${name + lastName} I'm 20"); // 약간 jsp 같다

    println("is this true? ${1 == 0}");
    println("this is 2\$"); // 그냥 쓰고 싶을 때

    /**
    * 여어어어러 주우우웅울 주우우우석석
    **/

    checkNum(40);

}

// 1. 함수
// - return type 이 void 일 때 Unit
// - default 값이므로 없어도 무관
fun helloWorld() : Unit {
    println("Hello Kotlin World!");
}

// java, c 랑 다른 점
// 변수 명이 먼저 선언되고 뒤에 자료형이 붙는다 (int = Int)
fun add(a : Int, b : Int) : Int {
    return a + b;
}

// 2. var vs val
// val == value
fun hi() {
    // 상수
    val a : Int = 10;
    // 변수
    var b : Int = 9;

    // kotlin 은 자료형을 알아서 다 해줌 js 같이
    var str = "minHong";
    val number = 20;

    // 단 값을 안넣어 줬을 때는 자료형 선언이 필요함
    // var apply;
    var apply : String;
}

// 4. 조건식
fun maxBy(a : Int, b : Int) : Int {
    // 강의에서는 이렇게 나왔지만 idle 에서
    /*if (a > b) {
        return a;
    } else {
        return b;
    }*/
    // 이렇게 바꿔줌!!!
    return if (a > b) {
        a;
    } else {
        b;
    }
}

// kotlin 에서는 삼항연산자가 없음
// 타입선언 대신 if 문을 넣어 간단하게 코드를 짤 수 있다! 신세계
fun maxBy2(a : Int, b : Int) = if (a > b) a else b;

fun checkNum(score : Int) {
    when(score) {
        0 -> println("this is 0!");
        1 -> println("this is 1!");
        2, 3 -> println("this is 2 or 3!");
        // else -> println("I don't know..."); 함수는 안써줘도 됨
    }

    val num = when(score) {
        1 -> 1;
        2 -> 2;
        else -> 0;  // else 필요
    }

    println("num : $num")

    when (score) {
        in 90 .. 100 -> println("You are genius"); // 90 ~ 100 사이
        in 10 .. 80 -> println("not bad"); // 10 ~ 80 사이
        else -> println("okay"); // 80 ~ 90 사이
    }
}

// Expression vs Statement
// kotlin 의 모든 함수는 expression 임
// return 타입이 없더라도 Unit 을 반환하기 때문임
// java function return void 는 Statement 임
// if 문도 statement 였는데 코틀린에서는 if 문을 expression으로 사용할 수 있다

