package chapter9

fun main() {
    val mixedTypesSet = setOf("Hello", 5, "world", 3.14, 'c') // 자료형 혼합 초기화
    val intSet = setOf(1, 5, 5) // 정수형만 초기화

    println(mixedTypesSet)
    println(intSet)
}