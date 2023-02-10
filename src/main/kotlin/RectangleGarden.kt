open class RectangleGarden(var rectangleWide: Double = 0.0, var rectangleHeight: Double = 0.0): Sensor() {

    var numberOfSensors: Double = 0.0
    var size: Double = 0.0

    init {
        rectangleWide = getValidDoubleInput("Enter the width of the rectangular garden: ")
        rectangleHeight = getValidDoubleInput("Enter the height of the rectangular garden: ")
        calculateSize()
        numberOfSensors = calculateNumberOfSensors().toDouble()

    }

    private fun getValidDoubleInput(inputMessage: String): Double {
        while (true) {
            println(inputMessage)
            val inputString = readLine()
            if (inputString != null) {
                try {
                    val input = inputString.toDouble()
                    return input
                } catch (ex: Exception) {
                    println("Check your input. Please enter a valid number.")
                }
            }
        }
    }

    private fun calculateSize() {
        size = rectangleWide * rectangleHeight
    }

    override fun toString(): String {
        return "The area of your rectangle garden is ${"%.2f".format(size)} square units."
    }

    fun calculateNumberOfSensors(): Int {
        val result = (size * 4).toInt()
        println("You need $result nozzles.")
        return result
    }
}

