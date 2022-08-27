package chapter9

fun main() {
    // 가변형 List를 생성하고 자바의 ArrayList로 반환
    val stringList: ArrayList<String> = arrayListOf("Hello", "Kotlin", "Wow")
    stringList.add("Java") // 추가
    stringList.remove("Hello") // 삭제
    println(stringList)
}