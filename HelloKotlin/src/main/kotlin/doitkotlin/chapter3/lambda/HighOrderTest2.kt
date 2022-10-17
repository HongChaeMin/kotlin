package doitkotlin.chapter3.lambda

fun main() {
    // 찢었다...
    val result = highOrder({ x, y -> x + y }, 10, 20)
    println(result)
}

fun highOrder(sum: (Int, Int) -> Int, a: Int, b: Int): Int {
    return sum(a, b)
}