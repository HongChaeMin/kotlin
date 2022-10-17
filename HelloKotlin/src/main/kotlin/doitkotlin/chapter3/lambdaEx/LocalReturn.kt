package doitkotlin.chapter3.lambdaEx

fun main() {
    shortFuncL(3) {
        println("First call: $it")
        return // ①
    }
}

inline fun shortFuncL(a: Int, out: (Int) -> Unit) {
    println("Before calling out( )")
    out(a)
    println("After calling out( )") // ②
}
