import java.awt.Color

open class WateringActivation(
    var nozzleSize: Int = 5,
    var bar: Double = 0.03
) {
    fun printNozzleSize() {
        println("A Sprinkler has a nozzle size of ${nozzleSize * 3}.")
    }

    fun printBar() {
        println("The sprenkele work with ${bar}")
    }
}