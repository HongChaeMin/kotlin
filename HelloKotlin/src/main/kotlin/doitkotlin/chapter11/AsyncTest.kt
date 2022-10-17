package doitkotlin.chapter11

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val jobs = List(100_000) { // 많은 양의 코루틴을 위한 List
        launch {
            delay(1000L)
            print(".")
        }
    }
    jobs.forEach { it.join() } // 모든 jobs가 완료될 때가지 기다림

    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doWork1() }
        val two = async(start = CoroutineStart.LAZY) { doWork2() }

        println("AWAIT: ${ one.await() + "_" + two.await() }")
    }
    println("Completed in $time ms")
}