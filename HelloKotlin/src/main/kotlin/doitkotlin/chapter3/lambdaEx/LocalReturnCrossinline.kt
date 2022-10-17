package doitkotlin.chapter3.lambdaEx

fun main() {
    shortFuncC(3) {
        println("First call: $it")
        // return 사용 불가
    }
}

inline fun shortFuncC(a: Int, crossinline out: (Int) -> Unit) {
    println("Before calling out( )")
    nestedFunc { out(a) }
    println("After calling out( )")
}

fun nestedFunc(body: () -> Unit) {
    body()
}