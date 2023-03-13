var width = 5
var height = 5
var currentPositionX: Int = width/2
var currentPositionY: Int = height/2
var arr = Array(width) { IntArray(height) }

fun main() {
    arr[currentPositionY][currentPositionX] = 1
    renderMap(arr)

    while(true){
        print("Would you like to move Up,Down,Left,Right?: ")
        var direction = parseDirection(readln())
        if(direction != "invalid"){
            updatePosition(direction)
        } else {
            println("Invalid direction please try again")
        }

        renderMap(arr)
    }
}

fun updatePosition(direction: String) {
    arr[currentPositionY][currentPositionX] = 0
    when (direction) {
        "up" -> if(currentPositionY-1 < 0){}else{currentPositionY--}
        "down" -> if(currentPositionY+1 > height -1){}else{currentPositionY ++}
        "left" -> if(currentPositionX-1 < 0){}else{currentPositionX--}
        "right" -> if(currentPositionX+1 > width -1){}else{currentPositionX++}
        else -> "invalid"
    }
    arr[currentPositionY][currentPositionX] = 1
}

fun parseDirection(userInput: String): String {

    return when (userInput.lowercase()) {
        "up", "u" -> "up"
        "down", "d" -> "down"
        "left", "l" -> "left"
        "right", "r" -> "right"
        else -> "invalid"
    }
}

fun renderMap(arr: Array<IntArray>){
    for (row in arr) {
        println(row.contentToString())
    }
}