package doitkotlin.chapter8

fun <T> add(a: T, b: T, op: (T, T) -> T): T {
    return op(a, b)
}

fun main() {
    val result = add(2, 3) { a, b -> a + b }
    println(result)

    println(add(2, 3, sumInt))
    println(add(2, 3, sumInt2))
}

var sumInt: (Int, Int) -> Int = { a, b -> a + b } // 변수 선언부가 있는 경우 표현식의 자료형 생략
var sumInt2 = { a: Int, b: Int -> a + b } // 변수 선언부가 생략된 경우에는 표현식에 자료형 표기
