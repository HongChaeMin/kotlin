package doitkotlin.chapter5.exClass

class BirdSecondaryConstructor(
    var name: String, var wing: Int, var beak: String, var color: String
) {

    init { // 초기화 블록
        println("----------초기화 블록 시작----------")
        println("이름은 $name, 부리는 $beak")
        this.sing(3)
        println("---------- 초기화 블록 끝 ----------")
    }

    // 메서드
    fun fly() = println("Fly wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

fun main() {
    val coco = BirdSecondaryConstructor("myBird", 2, "short", "blue") // ④ 생성자의 인자로 객체 생성과 동시에 초기화
    coco.color = "yellow"

    println("coco.color: ${coco.color}")
    coco.fly( )
    coco.sing(3)
}