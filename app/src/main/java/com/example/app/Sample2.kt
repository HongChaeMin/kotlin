package com.example.app

// 1. Lamda
// - 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다
//     1) 메소드의 파라미터로 넘겨줄 수 있다 fun maxBy(a : Int)
//     2) return 값으로 사용할 수가 있다

// 람다의 기본 정의
// - [val] [lamdaName] : [Type] -> [returnType] = {[argumentList] -> [codeBody]}

// 타입을 선언 안하면 타입 추론을 못하기 때문에 codeBody 나 type 선언 부분에 선언 해주어야한다
val square : (Int) -> (Int) = {number -> number * number};
val square2 = {number : Int -> number * number};

val nameAge = {name : String, age : Int -> "my name is $name, I'm $age"};
val nameAge2 : (String, Int) -> (String) = {name, age -> "my name is $name, I'm $age"};

fun main() {
    println(square(2));
    println(nameAge2("minHong", 20));

    val a = "minHong said";
    val b = "ChaeMin said";
    println(a.pizzaIsGreat());
    println(b.pizzaIsGreat());

    println(extendString("minHong", 20));

    println(calculateGarage(111));
    println(calculateGarage(99));

    val lamda = {number : Double ->
        number == 4.3214;
    }

    println(invokeLamda(lamda)); // false

    // () 생략 가능
    // 마지막 파라미터로 람다 식일 때 가능
    println(invokeLamda { it > 3.22 }); // true
    println(invokeLamda { true }); // true
    println(invokeLamda {number : Double -> number < 3.22}); // false
}

// 2. 확장 함수
val pizzaIsGreat : String.() -> String = {
    "$this Pizza is the best!"
}

fun extendString(name : String, age : Int): String {
    // this 는 자기 자신의 값 - String.(Int) 중 String
    // it 은 매개 변수가 하나일 때 it 사용 가능 - String.(Int) 중 Int
    val introduceMyself : String.(Int) -> String = {"I an $this and $it years old"}
    return name.introduceMyself(age);
}

// 3. 람다의 리턴
val calculateGarage : (Int) -> String = {
    // 마지막 표현식이 리턴의 value 값을 지정
    when (it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 4. 람다를 표현하는 여러가지 방법
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return (lamda(5.2343));
}