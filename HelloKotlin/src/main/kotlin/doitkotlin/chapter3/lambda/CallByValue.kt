package doitkotlin.chapter3.lambda

fun main() {

    val result = callByValue(lambda()) // 람다식 함수를 호출
    println(result)

}

fun callByValue(b: Boolean): Boolean { // 일반 변수 자료형으로 선언된 매개변수
    println("callByValue function")
    return b
}

val lambda = { // 람다 표현식이 2줄 (타입 선언 생략, 책에는 나옴)
    println("lambda function")
    true // 마지막 표현식 문장의 결과가 반환
}
