open class SquareGarden(var squareWide: Double = 0.0) : Sensor(){
    var numberOfSensors: Double =0.0
    private val sensorsPerSquareMeter = 4
    var size = 0.0

    init {
        readSquareWide()
        calculateSize()
    }

    private fun readSquareWide() {
        println("Enter the length of one side of your square garden:")
//  die Funktion readLine().wird in einer schleife überprüft, ob der eingegebene Wert input entweder null oder leer ist oder ob er keine gültige Zahl darstellt.
// (d.h. das Ergebnis von input.toDouble().isValidNumber() ist false) oder ob die gültige Zahl kleiner oder gleich Null ist.
//  bei erfüllen einer bedingung wird eine nachricht ausgegeben "Invalid input. Please enter a positive number." somit wird der nutzer aufgefordert um eine neue eingabe
//  Die Schleife wird so oft fortgesetzt, bis ein gültiger positiver numerischer Wert eingegeben wurde.
        var input: String? = readLine()
        while (input.isNullOrBlank() || !input.toDouble().isValidNumber() || input.toDouble() <= 0) {
            println("Invalid input. Please enter a positive number.")
            input = readLine()
        }
        squareWide = input.toDouble()
    }

    private fun calculateSize() {
        size = squareWide * squareWide
    }

    override fun toString(): String {
        return "Your garden is square with a size of ${"%.2f".format(size)} square meters."
    }

    private fun String.toDouble(): Double {    //Dieser Code ist eine Erweiterungsfunktion für die Klasse String, Es definiert eine Funktion namens "toDouble",
        return toDoubleOrNull() ?: Double.NaN  //die eine Zeichenfolge als Eingabe nimmt und sie in eine Double-Zahl konvertiert.
    }                                          //Wenn die Zeichenfolge keine gültige Double-Zahl ist, wird stattdessen der Wert Double.NaN (Not-a-Number) zurückgegeben.
//Dieser Code ist eine Erweiterungsfunktion für den Datentyp Double.
// Die Funktion "isValidNumber" überprüft, ob ein bestimmter Wert eine
// gültige Zahl (kein NaN-Wert) ist. Dies wird erreicht, indem mit dem "isNaN()"
// -Aufruf geprüft wird, ob der aktuelle Wert (this) gleich NaN ist. Wenn dies der Fall ist, gibt die Funktion "false" zurück, andernfalls "true".
    private fun Double.isValidNumber(): Boolean {// ist für die zeile geschrieben.
        return !this.isNaN()
    }

    fun calculateNumberOfSensors(): Int {                  //berechnung für die anzahl der düsen pro Quadratmeter fläche
        val result = (size * sensorsPerSquareMeter).toInt()
        println("You need $result nozzles")
        return result
    }
}
