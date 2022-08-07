package chapter3.lambdaEx

import java.util.concurrent.locks.ReentrantLock

var sharable = 1 // 보호가 필요한 공유 자원

fun main() {
    val reLock = ReentrantLock()
    // ①, ②, ③ 표현식이 모두 동일
    lock(reLock, { criticalFunc() }) // ①
    lock(reLock) { criticalFunc() } // ②
    lock(reLock, ::criticalFunc) // ③

    println(sharable)
}

fun criticalFunc() {
    // 공유 자원 접근 코드 사용
    sharable += 1
}

fun <T> lock(reLock: ReentrantLock, body: () -> T): T {
    reLock.lock()
    try {
        return body()
    } finally {
        reLock.unlock()
    }
}
