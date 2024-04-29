package hellokotlin

class KotlinApp {
    public fun getGreeting(): String {
        return "Hello World in Kotlin!";
    }
}

var greetingFunction: () -> Unit = { println("Hello World!") }

var anotherGreetingFunction: (String) -> String = { 
    "Hello $it!"
}

fun checkType(value: Any?) {
    when(value) {
        null -> println("It's null")
        is Int -> println("It's an integer: $value")
        is String -> println("It's a string: $value")
    }
}

fun getOutput(value: Any?): String = when(value) {
    null -> "Input was null"
    is Int -> "Input was an Int"
    is String -> "Input was a string with length: ${value.length}"
    is Float, is Double -> "Input was non Int Number"
    else -> "Input didn't match target inputs"
}

fun main() {
    // val aGenericVariable: Any = 5
    // val anIntVariable: Int = aGenericVariable as Int
    // var anotherGenericVariable: Any = "Hello"
    // val aString = anotherGenericVariable as String
    // checkType(aGenericVariable)
    // checkType(anotherGenericVariable)
    // checkType(null)

    println(getOutput(null))
    println(getOutput(4))
    println(getOutput(3.2))
    println(getOutput("Hello Kotlin"))
    println(getOutput('a'))
}

fun tryCatchFun() {
    val number = try {
    Integer.parseInt("XYZ")
  } catch (e: NumberFormatException) {
    println("Not a number")
    println("Caught exception: $e")
    0
  }
  println("Done with try-catch block, number: $number")
}

fun whenFun() {
     printCalculatedValue(10, 5, {a, b -> a - b})
    printCalculatedValue(10, 5) {a, b -> a + b} //trailing lambda syntax
    printFormattedName("John", "Doe") {firstName, lastName -> "$firstName $lastName"}
    printFormattedName("John", "Doe") {firstName, lastName -> "Firstname: $firstName Lastname: $lastName"}

    val someVariable = 7
    when {
        someVariable > 3 -> println("Greater than 3")
        someVariable > 2 -> println("Greater than 2")
        else -> println("Not greater")
    }

    when(someVariable) {
        0, 1 -> println("Zero or One")
        2 -> println("Two")
        3 -> println("Three")
        in 4..10 -> println("Between 4 and 10")
    }
}

fun printCalculatedValue(val1: Int, val2: Int, calcFun: (Int, Int) -> Int): Unit {
    println("The value is ${calcFun(val1, val2)}")
}

fun printFormattedName(firstName: String, lastName: String, formatter: (String, String) -> String) {
    println(formatter(firstName, lastName))
}


fun printGreeting() = println("Whats up?")

fun nullPoint(){
    var aNullString: String? = "kotlin"

    println(aNullString?.length ?: "the value was null")
}

fun chars() {
    val aChar: Char = 'a'
    val aNumericChar: Char = '9'
    val newLineChar: Char = '\n'

    //val concatOption1:String = 'a' + 'b'
    val aString = "Hello Kotlin"
    val escaped = "Hello \n Kotlin"

    val raw = """
      |Hello
    again
    we meet again
        do you knoww 
            me again?
          |black black 
        |one more time 
    """.trimMargin()

    println(raw)

    val aNumber = 100
    val concat = "   "

    val concatNumber = "Number: ${aNumber + 1}"

    println(concat)
    println(concatNumber)

    println("isEmpty ${concat.isEmpty()}")
    println("isNotEmpty ${concat.isNotEmpty()}")
    println("isBlank ${concat.isBlank()}")
}