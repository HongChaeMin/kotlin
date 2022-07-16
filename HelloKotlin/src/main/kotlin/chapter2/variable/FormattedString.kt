package chapter2.variable

fun main() {
    val num = 10
    val formattedString = """
        var a = 6
        var b = "Kotlin"
        println(a + num)
    """
    println(formattedString)

    // 오오
    val user: Username = "Hannah" // 이제부터 Username은 String과 같은 표현
    println(user is String)
}
typealias Username = String // String을 Username이라는 별명으로 대체