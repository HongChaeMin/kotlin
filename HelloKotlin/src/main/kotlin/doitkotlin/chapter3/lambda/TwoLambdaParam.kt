package doitkotlin.chapter3.lambda

fun main() {
    // 2개의 람다식을 매개변수로 가진 함수의 사용
    twoLambda({ a, b -> "First $a $b" }, { "Second $it" })
    twoLambda({ a, b -> "First $a $b" }) { "Second $it" } // 위와 동일
}

fun twoLambda(first: (String, String) -> String, second: (String) -> String) {
    println(first("OneParam", "TwoParam"))
    println(second("OneParam"))
}
