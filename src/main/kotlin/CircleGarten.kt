import kotlin.math.PI

open class CircleGarden(var circleRadius: Double = 0.0) : Sensor() {
    var numberOfSensors: Double = 0.0
    private val sensorsPerSquareMeter = 4
    var size = 0.0

    init {
        readCircleRadius()
        calculateSize()
    }

    private fun readCircleRadius() {
        println(
            "Enter the radius of your circle. You can find the radius by \n line from one point to the longest point and dividing it by 2."
        )

        var input: String? = readLine()
        while (input.isNullOrBlank() || !input.toDouble().isValidNumber() || input.toDouble() <= 0) {
            println("Invalid input. Please enter a positive number.")
            input = readLine()
        }
        circleRadius = input.toDouble()
    }

    private fun calculateSize() {
        size = PI * circleRadius * circleRadius
    }

    override fun toString(): String {
        return "Your garden is circular with a size of ${"%.2f".format(size)} square meters."
    }

    private fun String.toDouble(): Double {
        return toDoubleOrNull() ?: Double.NaN
    }

    private fun Double.isValidNumber(): Boolean {
        return !this.isNaN()
    }

    fun calculateNumberOfSensors(): Int {
        val result = (size * sensorsPerSquareMeter).toInt()
        println("You need $result nozzles")
        return result
    }
}
