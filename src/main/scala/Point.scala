final case class Point(x: Int, y: Int)

class PointClass(x: Int, y: Int){
    def log(message: String, level: String = "INFO") = println(message + x)
}
