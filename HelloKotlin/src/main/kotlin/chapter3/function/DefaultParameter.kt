package chapter3.function

fun main() {
    val name = "홍채민"
    val email = "coals0329@cocen.com"

    add(name)
    add(name, email)
    add("둘리", "ghdcoalss33@gmail.com")

    defaultArgs( ) // ① 100 + 200
    defaultArgs(200) // ② 200 + 200
}

fun add(name: String, email: String = "default") {
    val output = "${name}님의 이메일은 ${email}입니다."
    println(output)
}

fun defaultArgs(x: Int = 100, y: Int = 200) {
    println(x + y)
}