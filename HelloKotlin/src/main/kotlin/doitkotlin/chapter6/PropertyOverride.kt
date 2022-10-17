package doitkotlin.chapter6

open class First {
    open val x: Int = 0 // ① 오버라이딩 가능
        get() {
            println("First x")
            return field
        }
    val y: Int = 0 // ② open 키워드가 없으면 final 프로퍼티
}

class Second : First() {
    override val x: Int = 0 // ③ 상위 클래스와 구현부가 다르게 오버라이딩됨
        get() {
            println("Second x")
            return field + 3
        }
    // override val y: Int = 0 // ④ 오류! 오버라이딩 불가
}

fun main() {
    val second = Second()
    println(second.x) // ⑤ 오버라이딩된 두 번째 클래스 객체의 x
    println(second.y) // 상위 클래스로부터 상속받은 값
}
