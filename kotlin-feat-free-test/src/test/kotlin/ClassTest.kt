import org.junit.jupiter.api.Test

class ClassTest {

    @Test
    fun kotlinClass() {
        val student = Student("Minsu", 18)
        student.study()
    }
}

class Student(
    val name: String = "test",
    val age: Int = 20
){
    fun study(){
        println("I am a student")
    }
}