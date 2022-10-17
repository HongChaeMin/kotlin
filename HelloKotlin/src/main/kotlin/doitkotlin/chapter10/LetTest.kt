package doitkotlin.chapter10

fun main() {
    val score: Int? = 32
    // var score = null

    // 일반적인 null 검사
    fun checkScore() {
        if (score != null) {
            println("Score: $score")
        }
    }

    // let 함수를 사용해 null 검사를 제거
    fun checkScoreLet() {
        score?.let { println("Score: $it") } // ①
        val str = score.let { it.toString() } // ②
        println(str)
    }

    checkScore()
    checkScoreLet()
}