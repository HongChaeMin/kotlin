package doitkotlin.chapter8

class GenericNull<T> { // 기본적으로 null이 허용되는 형식 매개 변수
    // null을 허용하지 않게 하려면 <T: Any> 로 선언하면 된다

    fun equalityFunc(arg1: T, arg2: T) {
        println(arg1?.equals(arg2))
    }
}

fun main() {

    val obj = GenericNull<String>() // non-null로 선언됨
    obj.equalityFunc("Hello", "World") // null이 허용되지 않음

    val obj2 = GenericNull<Int?>() // null이 가능한 형식으로 선언됨
    obj2.equalityFunc(null, 10)
}

