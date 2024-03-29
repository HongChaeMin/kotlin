package doitkotlin.chapter9

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val listMixed = listOf(1, "Hello", 3, "World", 5, 'A')
    val listWithNull = listOf(1, null, 3, null, 5, 6)
    val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)
    val map = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")

    // filter: 식에 따라 요소를 골라내기
    println(list.filter { it % 2 == 0 }) // 짝수만 골라내기
    println(list.filterNot { it % 2 == 0 }) // 식 이외에 요소 골라내기
    println(listWithNull.filterNotNull()) // null을 제외

    // filterIndexed: 인덱스와 함께 추출
    println("filterIndexed: " + list.filterIndexed { idx, value -> idx != 1 && value % 2 == 0 })

    // filterIndexedTo: 추출 후 가변형 컬렉션으로 변환
    val mutList = list.filterIndexedTo(mutableListOf()) { idx, value -> idx != 1 && value % 2 == 0 }
    println("filterIndexedTo: $mutList")

    // filterKeys/filterValues: Map의 키, 값에 따라 추출
    println("filterKeys: " + map.filterKeys { it != 11 }) // 키 11을 제외한 요소
    println("filterValues: " + map.filterValues { it == "Java" }) // 값이 "Java"인 요소

    // filterIsInstance: 여러 자료형의 요소 중 원하는 자료형을 골라냄
    println("filterIsInstance: " + listMixed.filterIsInstance<String>( ))
}