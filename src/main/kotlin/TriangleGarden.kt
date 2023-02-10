open class TriangleGarden(var triangleBase: Double = 0.0, var triangleHeight: Double = 0.0) :Sensor() {
    var numberOfSensors: Double = 0.0
    var size = 0.0

    init {
        readTriangleBase()
        readTriangleHeight()
        calculateSize()
    }

    private fun readTriangleBase() {
        println("Enter the base of your triangle garden.")

        var input: String? = readLine()
        while (input.isNullOrBlank() || !input.toDouble().isValidNumber()) {
            println("Invalid input. Please enter a valid number.")
            input = readLine()
        }
        triangleBase = input.toDouble()
    }

    private fun readTriangleHeight() {
        println("Enter the height of your triangle garden.")

        var input: String? = readLine()
        while (input.isNullOrBlank() || !input.toDouble().isValidNumber()) {
            println("Invalid input. Please enter a valid number.")
            input = readLine()
        }
        triangleHeight = input.toDouble()
    }

    private fun calculateSize() {
        size = triangleBase * triangleHeight / 2
    }

    override fun toString(): String {
        return "Your garden is a triangle with a size of ${"%.2f".format(size)} square meters."
    }

    private fun String.toDouble(): Double {
        return toDoubleOrNull() ?: Double.NaN
    }

    private fun Double.isValidNumber(): Boolean {
        return !this.isNaN()
    }

    fun calculateNumberOfSensors(): Int {
        val result = (size * 4).toInt()
        println("You need $result nozzles.")
        return result
    }
}
