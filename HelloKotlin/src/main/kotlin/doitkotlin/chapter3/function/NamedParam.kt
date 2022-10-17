package doitkotlin.chapter3.function

fun main( ) {
    namedParam(x = 200, z = 100) // x, z의 이름과 함께 함수 호출(y는 기본값 사용)
    namedParam(z = 150) // z의 이름과 함께 함수 호출(x와 y는 기본 값으로 지정됨)
}

fun namedParam(x: Int = 100, y: Int = 200, z: Int) {
    println(x + y + z)
}