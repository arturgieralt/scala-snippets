
object Fibonacci {

  def fib(n: Int): Int = {
      @annotation.tailrec
        def go(number: Int, current: Int, next: Int): Int = {
            if( number <= 1) current
            else go(number - 1, next, current + next)
        }

    go(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    println(fib(6))
  }
}

object IsSorted {

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
      @annotation.tailrec
        def loop(current: Int): Boolean = {
            println(current, as.length)
            if(current >= (as.length - 1))  return true
            
            val isPairOrdered = ordered(as(current), as(current + 1))

            if(!isPairOrdered) false
            else loop(current + 1)
        }

    loop(0)
  }

  def orderAscFn(first: Int, second: Int): Boolean = first <= second

  def main(args: Array[String]): Unit = {
      val array = Array(7, 8,9, 10, 9)
      println(isSorted(array, orderAscFn))
      
  }
}

object Currying {

  def curry[A,B,C](f: (A, B) => C): A => (B => C) = a => b => f(a, b)
  def unCurry[A,B,C](f: A => B => C): (A,B) => C = (a,b) => f(a)(b)
  def compose[A,B,C](f: B => C, g: A => B): A => C = a => f(g(a))

  def main(args: Array[String]): Unit = {
  
  }
}

