sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons [+A](head: A, tail: List[A]) extends List[A]

object List {
    def sum(ints: List[Int]): Int = ints match {
        case Nil => 0
        case Cons(head, tail) => head + sum(tail)
    }
    
    def product(ds: List[Double]): Double = ds match {
        case Nil => 1.0
        case Cons(0.0, _) => 0.0
        case Cons(head, tail) => head * product(tail)
    }

    def tail[A](list: List[A]): List[A] = list match {
        case Cons(_, tail) => tail        
        case _ => sys.error("No tail to be returned")
    }

    def drop[A](l: List[A], n: Int): List[A] = {
        def loop(t: List[A], current: Int): List[A] = {
            if (current <= 1) {
                return tail(t)
            }
            loop(tail(t), current - 1)
        }

        loop(l,n)
    }

    def dropWhile[A](l: List[A], n: Int): List[A] = {
        def loop(t: List[A], current: Int): List[A] = {
            if (current <= 1) {
                return tail(t)
            }
            loop(tail(t), current - 1)
        }

        loop(l,n)
    }

    def setHead[A](list: List[A], head: A): List[A] = list match {
        case Nil => Cons(head, Nil)
        case Cons(h, tail) => Cons(head, tail)
    }

    def apply[A](as: A*): List[A] =
        if (as.isEmpty) Nil
        else Cons(as.head, apply(as.tail: _*))
}

object ListApp extends App {
    val x = List(1,2,3,4,5) match {
        case Cons(x, Cons(2, Cons(4, _))) => x
        case Nil => 42
        case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
        case Cons(h, t) => h + List.sum(t)
        case _ => 101
    }

    println(x)

    val y = List(1,2,3,4,5)
    val z = List.drop(y, 4)

    print(z.toString())

}