package chapter11

val fibonacciSeq = sequence {
    var a = 0
    var b = 1

    yield(1) // ① 지연 함수가 사용됨

    while (true) {
        yield(a + b) // ②
        val tmp = a + b
        a = b
        b = tmp
    }
}

fun main() {
    println(fibonacciSeq.take(8).toList()) // ③ 8개의 값을 획득
}