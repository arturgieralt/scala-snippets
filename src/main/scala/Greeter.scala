trait Greeter {
    def greet(name: String): Unit = {
        println("Hello" + name)
    }
}

class DefaultGreeter extends Greeter