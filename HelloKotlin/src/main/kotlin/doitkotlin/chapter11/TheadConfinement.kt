package doitkotlin.chapter11

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

// 단일 스레드 문맥을 선언
val counterContext = newSingleThreadContext("CounterContext")

var counter = 0

suspend fun massiveRun(context: CoroutineContext, action: suspend () -> Unit) {
    val n = 1000
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n) {
            GlobalScope.launch(context) {
                repeat(k) { action() }
            }
        }
        jobs.forEach { it.join() }
    }
    println("Completed ${ n * k } actions in $time ms")
}

fun main() = runBlocking<Unit> {
    massiveRun {
        withContext(counterContext) { // 단일 스레드에 가둠
            counter++
        }
    }

    println("Counter = $counter")
}