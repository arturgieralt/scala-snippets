abstract class A {
  val message: String
}
class B extends A {
  val message = "I'm an instance of class B"
}
trait C extends A {
  def loudMessage = message.toUpperCase()
}
class D extends B with C

// next example

abstract class AbsIterator[T] {
  def hasNext: Boolean
  def next(): T
}

class StringIterator(s: String) extends AbsIterator[Char]{
  type T = Char
  private var i = 0
  def hasNext = i < s.length
  def next(): Char = {
    val ch = s charAt i
    i += 1
    ch
  }
}

trait RichIterator[T] extends AbsIterator[T] {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next())
}

class RichStringIter extends StringIterator("Scala") with RichIterator[Char]


object MainMixin extends App {
    val richStringIter = new RichStringIter
    richStringIter.foreach(println)
}
