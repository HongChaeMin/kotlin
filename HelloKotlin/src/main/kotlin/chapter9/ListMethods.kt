package chapter9

fun main() {
    val names: List<String> = listOf("one", "two", "three")
    println(names.size) // List 크기
    println(names.get(0)) // 해당 인덱스의 요소 가져오기 (idle에서 바꾸라 그럼)
    println(names.indexOf("three")) // 해당 요소의 인덱스 가져오기
    println(names.contains("two")) // 포함 여부 확인 후 포함되어 있으면 true 반환
}