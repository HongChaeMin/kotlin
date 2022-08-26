package chapter8

import chapter8.limit.Box

class Box<T>(t: T) { // 형식 매개변수로 받은 인자를 name에 저장
    var name = t
}

fun main() {
    val box1: Box<Int> = chapter8.limit.Box<Int>(1) // 1은 Int 형이므로 Box<Int> 로 추록
    val box2: Box<String> =
        chapter8.limit.Box<String>("Hello") // Hello 는 String 형으로 Box<String> 으로 추론

    println(box1.name)
    println(box2.name)
}