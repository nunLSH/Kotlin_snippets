import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class NullSafetyTest {

    @Test
    fun notNullableType_notnull() {
        val name: String = "Kotlin"  // ? 없다면 null 할당 불가능
        assertNotNull(name)
    }

//    @Test
//    fun notNullableType_null() {
//        val name: String = null  // null cannot be a value (Compile error)
//        assertNotNull(name)
//    }

    @Test
    fun nullableType_notnull() {
        val nullableName: String? = "Kotlin"   // ? -> 값이 null 일 수도 아닐수도 (null/notnull 다 가능)
        assertNotNull(nullableName)
    }

    @Test
    fun nullableType_null() {
        val nullableName: String? = null
        assertNull(nullableName)
    }

    @Test
    fun safeCall() {
        val nullableName: String? = "Java"
        assertEquals(4, nullableName?.length)

        // nullableName.length  // Compile error
        nullableName?.length  // safeCall
    }

    @Test
    fun elvisOperator() {
        val nullableName: String? = null
        val result = nullableName?.length ?: 13
        println(result) // 13
        // == nullableName 의 값이 null 이 아니면 nullableName 의 length 의 값
        // 만약, nullableName 의 값이 null 이면 ? 13
    }

    @Test
    fun elvisOperator_notnull() {
        val nullableName: String? = "Kotlin"
        val result = nullableName?.length ?: 13
        println(result) // 6
    }

    /**
     * 수강생분들의 질문에 대한 답
     */

    // Kotlin 에서 기본타입인 int 같은 것은 없는 건가요? int 를 써보니 Integer 로 변환이 됩니다
    @Test
    fun Type() {
        val number: Int = 1
        val prime: Double = 1.1

        // Java
        // primitive type: int, long, byte, double
        // wrapper class: Integer, Long, String, Double
        // Kotlin 은 전부 wrapper 타입이다.
    }

    // wrapper 를 기본적으로 쓴다면, Kotlin 에서 선언된 변수들은 stack 에 저장이 안 되나요?
    @Test
    fun jvm_memory() {
        // 답: stack 에 저장됨
        // (참고) https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EB%B3%B4%EB%8A%94-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%93%9C%EC%9D%98-%EB%A9%94%EB%AA%A8%EB%A6%AC-%EC%98%81%EC%97%AD%EC%8A%A4%ED%83%9D-%ED%9E%99
        val number: Int = 1
//        val person: Person = Person()
    }
}