package doitkotlin.chapter11

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
fun main() {
    val job = GlobalScope.launch { // Job 객체의 반환
        delay(1000L)
        println("World!")
    }

    println("Hello,")
    println("job.isActive: ${ job.isActive }, completed: ${ job.isCompleted }")
    Thread.sleep(2000L)
    println("job.isActive: ${ job.isActive }, completed: ${ job.isCompleted }")
}