package doitkotlin.chapter3.lambda

fun main( ) {
    // ① 인자와 반환값이 있는 함수
    // 선언부의 람다 함수가 인자수와 자료형의 개수가 동일하면
    // 콜론 2개를 이용해 소괄호와 인자를 생략하고 사용 가능
    val res1 = funcParam(3, 2, ::sumFun)
    println(res1)

    // ② 인자가 없는 함수
    hello(::text) // 반환값이 없음

    // ③ 일반 변수에 값처럼 할당
    val likeLambda = ::sumFun
    println(likeLambda(6,6))
}

fun sumFun(a: Int, b: Int) = a + b

fun text(a: String, b: String) = "Hi! $a $b"

fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

fun hello(body: (String, String) -> String): Unit {
    println(body("Hello", "World"))
}