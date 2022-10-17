package doitkotlin.chapter3.lambdaEx

fun main( ) {
    shortFuncN(3) { println("First call: $it") }
}

inline fun shortFuncN(a: Int, noinline out: (Int) -> Unit) {
    println("Before calling out( )")
    out(a)
    println("After calling out( )")
}