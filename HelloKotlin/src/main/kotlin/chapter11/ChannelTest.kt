package chapter11

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()

    launch {
        // 여기에 다량의 CPU 연산 작업이나 비동기 로직을 둘 수 있음
        for (x in 1..5) channel.send(x * x)
    }

    repeat(5) { println(channel.receive()) } // 5개의 값을 채널로부터 받음
    println("Done!")
}