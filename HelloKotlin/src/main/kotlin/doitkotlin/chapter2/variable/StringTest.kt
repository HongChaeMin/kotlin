package doitkotlin.chapter2.variable

fun main() {
    val str1: String = "Hello"
    val str2 = "World"
    val str3 = "Hello"

    println("str1 === str2: ${str1 === str2}")
    println("str1 === str3: ${str1 === str3}")

}