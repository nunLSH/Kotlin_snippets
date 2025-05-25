import org.junit.jupiter.api.Test

class Variable {

    @Test
    fun immutable() {
        // 불변, 값 재할당 불가능 >> val
        val name = "jko"
//        name = "jko_v2"

        val name2 = "jko_v2"
    }

    @Test
    fun mutable() {
        // 값 재할당 가능 >> var
        var name = "jko"
        name = "jko_v2"

        println(name)
    }
}