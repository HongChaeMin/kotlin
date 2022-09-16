package chapter10

fun main() {
    print("Enter: ")
    val input = readLine()!! // String 기본형이기 때문에 !!.toInt() 형태로 호출 가능
    println("You entered: $input")
}