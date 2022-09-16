package chapter10

import java.io.File
import java.io.PrintWriter

fun main() {
    val outString = "안녕하세요!\tHello\r\nWorld!." // ① 문자열의 구성
    val path = "D:\\test\\testfile.txt"

    val file = File(path)
    val printWriter = PrintWriter(file)

    File(path).printWriter().use { it.println(outString) } // ② 파일에 출력

    // 같은거 1
    // printWriter.println(outString)
    // printWriter.close()

    // 같은거 2
    // File(path).printWriter().use { out -> out.println(outString) }
}