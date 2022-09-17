package chapter11

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.runBlocking

sealed class CounterMsg {
    object IncCounter : CounterMsg() // counter를 증가하기 위한 단방향 메시지
    class GetCounter(val response: SendChannel<Int>) : CounterMsg() // 응답 채널의 요청
}

// 새로운 counter actor를 위한 함수
fun CoroutineScope.counterActor() = actor<CounterMsg>(CommonPool) {
    var counter = 0 // actor의 상태로 공유되지 않음
    for (msg in channel) { // 들어오는 메시지 처리
        when (msg) {
            is CounterMsg.IncCounter -> counter++
            is CounterMsg.GetCounter -> msg.response.complete(counter)
        }
    }
}

fun main() = runBlocking<Unit> {
    val counter = counterActor() // actor의 생성
    GlobalScope.massiveRun {
        counter.send(CounterMsg.IncCounter)
    }
    // actor의 counter 값을 얻기 위해 요청
    val response = CompletableDeferred<Int>()
    counter.send(CounterMsg.GetCounter(response))
    println("Counter = ${ response.await() }")
    counter.close( ) // actor의 중단
}