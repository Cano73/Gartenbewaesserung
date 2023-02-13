// Bodenfeutigkeit  Temperatur  Regensensor
// TODO Der Sensor gibt den Sprenklern den Befehl wie oft und wieviel gegoßen werden muß. Auch definiert es in welchem Zyklus gegoßen werden muß
open class Sensor(
    var soilmoisture: Double = 65.0, val soilmoistureUnit: String = "percent",//soilmoisture ist die eigenschaft und sie bedeutet Bodenfeutigkeit. Die soilmoistureUnit
    var temperature: Int = 12, val temperatureUnit: String = "degree",//ist auch eine Eigenschaft und ist nicht feränderbar, weil sie den wert Prozent als festen bestandteil hat.
    var rainsensor: Double = 0.8, val rainsensorUnit: String = "Liter per square meter"//Dies gilt auch für temperature und rainsensor

): WateringActivation(){
    fun randomPlayback(): String {
        if (soilmoisture <= 65.0 && temperature >= 12 && rainsensor >= 0.8) {
            return "The soil moisture is too low. The system starts in the medium status."
        } else if (soilmoisture <= 65.0 && temperature >= 12 && rainsensor < 0.8) {
            return "The soil moisture is too low and there is no rain. The plant starts in the middle status."
        } else if (soilmoisture <= 65.0 && temperature < 12 && rainsensor < 0.8) {
            return "The soil moisture is too low, currently it is not raining right now either and the weather is very warm.\n Your garden will be watered until the standard values are reached."
        } else {
            return "Your garden currently does not need watering"
        }
    }
}