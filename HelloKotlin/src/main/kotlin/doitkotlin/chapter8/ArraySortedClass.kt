package doitkotlin.chapter8

data class Product(val name: String, val price: Double)

fun main() {
    val products = arrayOf(
        Product("Snow Ball", 870.00),
        Product("Smart Phone", 999.00),
        Product("Drone", 240.00),
        Product("Mouse", 333.55),
        Product("Keyboard", 125.99),
        Product("Monitor", 1500.99),
        Product("Tablet", 512.99))

    products.sortByDescending { it.price } // 값에 따라 정렬
    products.forEach { println(it) }

    products.sortWith { p1, p2 -> // Comparator를 이용해 두 객체를 비교하여 p1이 크면 1, 같으면 0, 작으면 -1
        when {
            p1.price > p2.price -> 1
            p1.price == p2.price -> 0
            else -> -1
        }
    }
    products.forEach { println(it) }

    // compareBy를 함께 사용해 2개의 정보 정렬
    products.sortWith(compareBy({ it.name }, { it.price }))
    products.forEach { println(it) }
}