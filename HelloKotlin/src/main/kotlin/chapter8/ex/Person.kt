package chapter8.ex

class Person(
    private val name: String,
    private val age: Int,
    private val gender: Gender,
    private val brith: String,
    private val job: Job
) {

    fun whyDiscountPolicy(): DiscountPolicy {
        return Job.getDiscountPrice(job)
    }
}