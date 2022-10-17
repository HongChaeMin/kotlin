package doitkotlin.chapter2.nullAndCast

fun main() {
    val str1 : String = "Hello Kotlin"
    // str1 = null // 오류! null을 허용하지 않음
    println("str1: $str1")

    var str2: String? = "Hello Kotlin"
    str2 = null
    println("str1: $str2")
    // println("str2: $str2, length: ${str2.length}") // null을 허용하면 실행될 수 없음
    // println("str2: $str2, length: ${str2!!.length}") // NPE 강제 발생 jdk version 11 -> compile error
    println("str2: $str2, length: ${str2?.length ?: -1}") // 세이프 콜과 엘비스 연산자 활용
    // if (str1 != null) str.length else -1 위와 동일.
}