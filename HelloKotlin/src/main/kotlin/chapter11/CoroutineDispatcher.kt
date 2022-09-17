package chapter11

import kotlinx.coroutines.*

fun main() = runBlocking {

    val jobs = arrayListOf<Job>()

    // Unconfined 문맥
    // - 호출자 스레드에서 코루틴을 시작하지만 첫 번째 지연점까지만 실행
    // - 특정 스레드나 풀에 가두지 않고, 첫 번째 일시 중단 후 호출된 지연 함수에 의해 재개
    // - 이 옵션을 지정하는것은 권장하지 않음
    jobs += launch(Dispatchers.Unconfined) { // 메인 스레드에서 작업
        println("Unconfined:\t\t  ${Thread.currentThread().name}")
    }

    jobs += launch(coroutineContext) { // 부모의 문맥, 여기서는 runBlocking의 문맥
        println("coroutineContext: ${Thread.currentThread().name}")
    }

    // 기본 문맥
    // - Dispatchers.Default 는 기본 문맥인 CommonPool에서 실행되고 GlobalScope 로도 표현
    // - 따라서 launch(Dispatchers.Default) { ... } 와 GlobalScope.launch { ... }는 같은 표현
    // - 이것은 공유된 백그라운드 스레드의 CommonPool에서 코루틴을 실행
    // - 스레드를 새로 생성하지 않고 기존에 있는 것을 이용
    // - 연산 중심의 코드에 적합
    jobs += launch(Dispatchers.Default) { // 디스패처의 기본값
        println("Default:\t\t  ${Thread.currentThread().name}")
    }

    // I/O 를 위한 문맥
    // - 입출력 위주의 동작을 하는 코드에 적합한 공유된 풀
    // - 블로킹 동작이 많은 파일이나 소켓 I/O 처리에 사용
    jobs += launch(Dispatchers.IO) { // 입출력 중심의 문맥
        println("IO:\t\t\t\t  ${Thread.currentThread().name}")
    }

    jobs += launch { // 아무런 인자가 없을 때
        println("main runBlocking: ${Thread.currentThread().name}")
    }

    // 새 스레드를 생성하는 문맥
    // - newSingleThreadContext는 사용자가 직접 새 스레드 풀을 만들 수 있다
    // - 새 스레드를 만들기 때문에 비용이 많이 들고 더 이상 필요하지 않으면 해제하거나 종료시켜야 한다
    // - 이 옵션은 성능상의 이유로 향후 변경 될 가능성이 크다
    // - 코루틴 안에 또 다른 코루틴을 정의하면 자식 코루틴이 된다
    // - 부모가 취소(cancel)되는 경우 자식 코루틴은 재귀적으로 취소된다
    // - 필요할 경우 join() 함수를 사용해 명시적으로 처리를 기다리도록 만들 수 있다
    jobs += launch(newSingleThreadContext("MyThread")) { // 새 스레드를 생성
        println("MyThread:\t\t  ${Thread.currentThread().name}")
    }

    jobs.forEach { it.join() }
}