package doitkotlin.chapter2.nullAndCast

fun main() {
    checkArg("Hello")
    checkArg(5)

    val my = MySingleton.myFunction()
    val my2 = MySingleton.myProperty
    println(my)
    println(my2)
}

object MySingleton {
    const val myProperty = 3
    fun myFunction() = "Hello"
}

fun checkArg(x: Any) { // 인자를 Any형으로 받음
    if (x is String) {
        println("x is String: $x")
    }
    if (x is Int) {
        println("x is Int: $x")
    }
}