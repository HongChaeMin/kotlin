package chapter6

open class Superman() {
    fun work() = println("Taking photos")
    fun talk() = println("Talking with people.")
    open fun fly() = println("Flying in the air.")
}

class Person2(
    private val name: String,
    private val age: Int
) {

    private var phoneNumber: String = "test"
        get() {
            return field
        }


}

fun main() {
    val pretendedMan = object: Superman() { // ① object 표현식으로 fly() 구현의 재정의
        override fun fly() = println("I'm not a real superman. I can't fly!")
    }

    pretendedMan.work()
    pretendedMan.talk()
    pretendedMan.fly()
}
