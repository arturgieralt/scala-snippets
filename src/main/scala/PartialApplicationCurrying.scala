
object PAMain extends App {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val res = numbers.foldLeft(0) _
    println(res((m, n) => m + n)) // 55
}

object CurryingMain extends App {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val res = numbers.foldLeft(0)((m, n) => m + n)
    println(res) // 55
}
