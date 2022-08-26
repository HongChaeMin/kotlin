package chapter8.limit

open class Animal(val size: Int) {
    fun feed() = println("Feeding...")
}

class Cat(val jump: Int): Animal(50)
class Spider(val poison: Boolean): Animal(1)

// ① 형식 매개변수를 Animal로 제한
class Box<out T: Animal>(val element: T) { // 주 생성자에서는 val만 허용

    fun getAnimal(): T = element // ② out은 반환 자료형에만 사용할 수 있음

    // fun set(new: T) { // ③ 오류! T는 in 위치에 사용할 수 없음
    //     element = new
    // }
}

fun main() {
    // 일반적인 객체 선언
    val c1: Cat = Cat(10)
    val s1: Spider = Spider(true)
    var a1: Animal = c1 // 클래스의 상위 자료형으로 변환하는 것은 아무런 문제 없음

    a1 = s1 // ④ a1은 Spider의 객체가 됨
    println("a1.size = ${a1.size}")

    val c2: Box<Animal> = Box<Cat>(Cat(10)) // ⑤ 공변성 - Cat은 Animal의 하위 자료형
    println("c2.element.size = ${c2.element.size}")

    // val c3: Box<Cat> = Box<Animal>(10) // ⑥ 오류! 반대의 경우는 인스턴스화되지 않음
    // val c4: Box<Any> = Box<Int>(10) // ⑦ 오류! 자료형을 제한하여 Animal과 하위 클래스 이외에는 사용할 수 없음
}
