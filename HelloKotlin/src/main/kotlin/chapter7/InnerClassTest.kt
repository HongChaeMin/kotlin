package chapter7

interface Switcher { // ① 인터페이스의 선언
    fun on(): String
}

@Suppress("UNREACHABLE_CODE")
class Smartphone(val model: String) {
    private val cpu = "Exynos"
    inner class ExternalStorage(val size: Int) {
        fun getInfo( ) = "${model}: Installed on $cpu with ${size}Gb" // 바깥 클래스의 프로퍼티 접근
    }

    fun powerOn(): String {

        class Led(val color: String) { // 지역 클래스 선언
            fun blink(): String = "Blinking $color on $model" // 외부의 프로퍼티는 접근 가능
        }

        val powerStatus = Led("Red") // 여기에서 지역 클래스가 사용됨

        val powerSwitch = object : Switcher { // ② 익명 객체를 사용해 Switcher의 on()을 구현
            override fun on(): String {
                return powerStatus.blink()
            }
        } // 익명(object) 객체 블록의 끝

        return powerSwitch.on() // 익명 객체의 메서드 사용

        return powerStatus.blink()
    } // powerOn() 블록 끝
}

fun main() {
    val mySdcard = Smartphone("S7").ExternalStorage(32)
    println(mySdcard.getInfo())
}