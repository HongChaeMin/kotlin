package doitkotlin.chapter3.lambda

fun main() {
    println("funcFunc: ${ funcFunc() }")
}

fun sum1(a: Int, b: Int) = a + b
fun funcFunc() = sum1(2, 2) // 함수의 반환값으로 함수 사용
