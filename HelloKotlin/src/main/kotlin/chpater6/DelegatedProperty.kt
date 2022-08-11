package chpater6

import kotlin.properties.Delegates

class DUser {
    var name: String by Delegates.observable("NONAME") { // ① 프로퍼티 위임
            prop, old, new -> // ② 람다식 매개변수로 프로퍼티, 기존 값, 새로운 값 지정
        println("$old -> $new") // ③ 이 부분은 이벤트가 발생할 때만 실행
    }
}

fun main() {
    val user = DUser()
    user.name = "Kildong" // ④ 값이 변경되는 시점에서 첫 이벤트 발생
    user.name = "Dooly" // ⑤ 값이 변경되는 시점에서 두 번째 이벤트 발생
}