//TODO main für die Gartenberechnung (alt)
import java.lang.Math.random as mathRandom
fun main() {
    println("Choose the type of your garden:")
    println("1. Rectangular Garden")
    println("2. Square Garden")
    println("3. Circle Garden")
    println("4. Triangle Garden")

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

    Thread.sleep(5000)
    println("Soil Moisture: ${sensor.soilmoisture} ${sensor.soilmoistureUnit}")

    Thread.sleep(5000)
    println("Temperature: ${sensor.temperature} ${sensor.temperatureUnit}")

    Thread.sleep(5000)
    println("Rain Sensor: ${sensor.rainsensor} ${sensor.rainsensorUnit}")

    Thread.sleep(5000)
    println("Random playback: ${sensor.randomPlayback()}")
}

private fun String?.isValidNumber(): Boolean {
    return !this.isNullOrBlank() && this.toIntOrNull() != null
}