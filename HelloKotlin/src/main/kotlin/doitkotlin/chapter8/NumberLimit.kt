package doitkotlin.chapter8

class Calc<T: Number> { // 클래스의 형식 매개변수 제한
    fun plus(arg1: T, arg2: T): Double {
        return arg1.toDouble() + arg2.toDouble()
    }
}

fun <T: Number> addLimit(a: T, b: T, op: (T, T) -> T): T {
    return op(a, b)
}

fun main() {
    val calc = Calc<Int>()
    println(calc.plus(10,20))

    val calc2 = Calc<Double>()
    val calc3 = Calc<Long>()
    // val calc4 = Calc<String>() // 제한된 자료형으로 인해 오류 발생!

    println(calc2.plus(2.5,3.5))
    println(calc3.plus(5L, 10L))

    // val result = addLimit("abc", "def", {a, b -> a + b}) // 제한된 자료형으로 인해 오류 발생!

    val obj1 = ClassA<HandlerA>() // 객체 생성 가능
    // val obj2 = ClassA<HandlerB>() // 범위에 없으므로 오류 발생!
}

interface InterfaceA
interface InterfaceB

class HandlerA: InterfaceA, InterfaceB
class HandlerB: InterfaceA

class ClassA<T> where T:InterfaceA, T:InterfaceB // 2개의 인터페이스를 구현하는 클래스로 제한
