import org.junit.jupiter.api.Test

class Collection {

    // immutable
    @Test
    fun immutableList() {
        val alphabets = listOf("A", "B", "C")  // 요소 변경 불가능
//        alphabets[0] = "F"
    }

    // mutable
    @Test
    fun mutableList() {
        val alphabets = mutableListOf("A", "B", "C")
        alphabets[0] = "F"
    }

    @Test
    fun others() {
        setOf(1, 2, 3)
        mutableSetOf(1, 2, 3)

        mapOf(1 to 2, 3 to 3)
        mutableMapOf(1 to 2, 3 to 3)
    }
}