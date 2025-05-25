import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Concise {

    @Test
    fun function() {
        val result = sum(1, 3)
        assertEquals(4, result)
    }

    private fun sum(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    private fun sum_more_concise(num1: Int, num2: Int): Int = num1 + num2

    @Test
    fun StringTemplate() {
        val name = "jko"
        val age = 30

        val introduce = "My name is $name and age is $age"
        println(introduce)
    }

    @Test
    fun lamda() {
        val numbers = listOf(1, 2, 3, 4, 5)
        val squares = numbers.map { it * it }
        println(squares)
    }

    @Test
    fun dataClass() {
        val p = Person(name = "jko", age = 30)
        println(p)

        // data class 내부에 함수가 없어도 객체가 생성될 때 기본 제공되는 함수가 있음
        val newP = p.copy(name = "Minsu")
        println(newP)
    }
}

// (강사님) JPA entity 클래스로 class 가 맞을까 data class 가 맞을까 >> class 로 작성해야 함

// data class
data class Person(
    val name: String,
    val age: Int
)

// 일반 class >> copy 등의 함수 제공 X
class PersonGeneral(
    val name: String,
    val age: Int
)