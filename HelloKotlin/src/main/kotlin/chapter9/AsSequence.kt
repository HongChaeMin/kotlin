package chapter9

fun main() {
    val list1 = listOf(1, 2, 3, 4, 5)
    val listDefault = list1
        .map { println("map($it) "); it * it } // ①
        .filter { println("filter($it) "); it % 2 == 0 } // ②

    println(listDefault)

    val listSeq = list1.asSequence()
        .map { print("map($it) "); it * it } // ①
        .filter { println("filter($it) "); it % 2 == 0 } // ②
        .toList() // ③

    println(listSeq)
}