package chapter8.ex

class ReservationService {

    fun reservation(person: Person) {
        val discountPolicy = person.whyDiscountPolicy()
        val discountPrice = discountPolicy.getDiscountPrice()

        // 저장 로직...
    }

}