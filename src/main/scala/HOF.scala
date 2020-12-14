object UrlProvider {
    def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
    }
}

case class WeeklyWeatherForecast(temperatures: Seq[Double]) {

  private def convertCtoF(temp: Double): Double = temp * 1.8 + 32

  def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
}



object HOFMain extends App {
    val domainName = "www.example.com"
    def getURL = UrlProvider.urlBuilder(ssl=true, domainName)
    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query)
    println(url)

    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val res = numbers.foldLeft(0) _
    println(res((m, n) => m + n)) // 55
}
