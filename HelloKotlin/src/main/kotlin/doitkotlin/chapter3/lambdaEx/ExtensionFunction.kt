package doitkotlin.chapter3.lambdaEx

fun main() {
    val source = "Hello World!"
    val target = "Kotlin"
    println(source.getLongString(target))
}

// String 클래스를 확장해 getLongString( ) 함수 추가
fun String.getLongString(target: String): String =
    if (this.length > target.length) this else target