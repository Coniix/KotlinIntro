fun main() {
    val me = Person("Conor", "Evans", 28)
    me.introduceSelf()

    val arnold = Person("Arnold", "Schwarzenegger", 75)
    arnold.introduceSelf()
}

class Person(private var firstName: String, private var secondName: String, private var age: Int){
    fun introduceSelf(){
        println("Hi, my name is ${this.firstName} ${this.secondName} and I am ${this.age} years old")
    }
}