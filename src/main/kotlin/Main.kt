//TODO main für die Gartenberechnung (alt)
import java.lang.Math.random as mathRandom

fun main() {
    val flag = Color()
    println("Bu bizim Canimiz\n ${flag}")

    val row1 = "\u001b[31m\u2588\u2588\u2588\u2588      \u2588\u2588\u2588      \u0020\u0020"
    val row2 = "\u001b[31m\u2588\u2588\u2588\u2588      \u2588\u2588\u2588      \u0020\u0020"
    val row3 = "\u001b[31m\u2588\u2588\u2588\u2588      \u2588\u2588\u2588      \u0020\u0020"
    val row4 = "\u001b[31m\u2588\u2588\u2588\u2588      \u2588\u2588\u2588      \u0020\u0020"

    println(row1)
    println(row2)
    println(row3)
    println(row4)

    val boxDrawingChar = "\u001b[31m\u2588\u2593\u2592\u2591\n\u001b[31m█▓▒░"
    println(boxDrawingChar)
    println()
    println("\u001b[31mChoose the type of your garden:")
    Thread.sleep(1000)
    println()
    println("\u001b[31m1. Rectangular Garden")
    Thread.sleep(1000)
    println()
    println("\u001b[31m2. Square Garden")
    Thread.sleep(1000)
    println()
    println("\u001b[31m3. Circle Garden")
    Thread.sleep(1000)
    println()
    println("\u001b[31m4. Triangle Garden")

    var input = readLine()
    while (!input.isValidNumber() || input!!.toInt() !in 1..4) {
        println("Invalid input. Please enter a number between 1 and 4.")
        input = readLine()
    }
    val choice = input?.toInt()
    /*  Hier wird durch diesen Code ein virtueller Garten erstellt,
    ausgegeben und die Anzahl der erforderlichen Sensoren berechnet,
    nachdem das Programm für 5 Sekunden pausiert hat.*/
    when (choice) {
        1 -> {
            val rectangleGarden = RectangleGarden()
            println(rectangleGarden.toString())
            Thread.sleep(5000)
            rectangleGarden.calculateNumberOfSensors()
        }

        2 -> {
            val squareGarden = SquareGarden()
            println(squareGarden.toString())
            Thread.sleep(5000)
            squareGarden.calculateNumberOfSensors()
        }

        3 -> {
            val circleGarden = CircleGarden()
            println(circleGarden.toString())
            Thread.sleep(5000)
            circleGarden.calculateNumberOfSensors()
        }

        4 -> {
            val triangleGarden = TriangleGarden()
            println(triangleGarden.toString())
            Thread.sleep(5000)
            triangleGarden.calculateNumberOfSensors()
        }
        //fun waterPlants(duration: Int)

    }

    val sensor = Sensor()
    sensor.soilmoisture = mathRandom() * 10
    sensor.temperature = (mathRandom() * 30).toInt()
    sensor.rainsensor = mathRandom() * 1
//sensor ist ein Objekt vom Typ Sensor.
//sensor.soilmoisture zufälligen Wert ausgabe zwischen 0 und 10 gesetzt.
//sensor.temperature Zufallszahl zwischen 0 und 30 gesetzt.
//sensor.rainsensor wird auf einen zufälligen Wert zwischen 0 und 1 gesetzt.
//Es wird angenommen, dass mathRandom() eine Funktion ist, die einen Zufallswert zwischen 0 und 1 generiert.

    val myWateringActivation = WateringActivation()
    myWateringActivation.printNozzleSize()
    println()
    Thread.sleep(5000)
    println("Soil Moisture: ${sensor.soilmoisture} ${sensor.soilmoistureUnit}")
    println()
    Thread.sleep(5000)
    println("Temperature: ${sensor.temperature} ${sensor.temperatureUnit}")
    println()
    Thread.sleep(5000)
    println("Rain Sensor: ${sensor.rainsensor} ${sensor.rainsensorUnit}")
    println()
    Thread.sleep(5000)
    println("Random playback: ${sensor.randomPlayback()}")
    println()
    //var duration: Int
    //3.also { duration = it }
    //println("Watering the plants for $duration seconds.")
    val random = java.util.Random()
    val duration: Int = random.nextInt(10) + 1
    println("Watering the plants for $duration seconds.")

}

private fun String?.isValidNumber(): Boolean {
    return !this.isNullOrBlank() && this.toIntOrNull() != null
}