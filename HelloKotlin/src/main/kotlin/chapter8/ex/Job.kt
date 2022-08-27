package chapter8.ex

enum class Job {
    STUDENT, TEACHER, ETC;

    companion object {

        fun getDiscountPrice(job: Job): DiscountPolicy {
            return when (job) {
                STUDENT -> StudentDiscountPolicy()
                TEACHER -> TeacherDiscountPolicy()
                else -> throw IllegalArgumentException("error")
            }
        }
    }
}
