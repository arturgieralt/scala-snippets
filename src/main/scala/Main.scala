object Main extends App {
  val greeter = new DefaultGreeter();

  greeter.greet(" World")

  val point =  Point(1,2)
  val secondPoint =  Point(1,2)

  if(point == secondPoint) {
    println("equal")
  }

  val d = new D
  println(d.message)  // I'm an instance of class B
  println(d.loudMessage)
}