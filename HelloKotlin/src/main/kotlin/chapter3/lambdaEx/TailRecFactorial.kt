package chapter3.lambdaEx

fun main() {
    val number = 5
    println("FactorialL $number -> ${ tailFactorial(number) }")
}

tailrec fun tailFactorial(n: Int, run: Int = 1): Long {
    return if (n ==1) run.toLong() else tailFactorial(n - 1, run * n)
}

