package doitkotlin.chapter5.prisecon

class Person(firstName: String,
             out: Unit = println("[Primary Constructor] Parameter")) { // ② 주 생성자

    val fName = println("[Property] Person fName: $firstName") // ③ 프로퍼티 할당

    init {
        println("[init] Person init block") // ④ 초기화 블록
    }

    // ① 부 생성자
    constructor(firstName: String, age: Int,
                out: Unit = println("[Secondary Constructor] Parameter")): this(firstName) {
        println("[Secondary Constructor] Body: $firstName, $age") // ⑤ 부 생성자 본문
    }
}

fun main() {
    val p1 = Person("Kildong", 30) // ① → ② 호출, ③ → ④ → ⑤ 실행
    println()
    val p2 = Person("Dooly") // ② 호출, ③ → ④ 실행
}