import mineSweeper.*
import java.util.*

var width: Int = 0
var height = 0
var mines = 0
var map: MineSweeperMap? = null
var playGame = true
fun main() {

    do {
        print("\n\n\n\n\n\n\n\n\n\n\nHow wide would you like your board: ")
        width = getInput()
    }while(width<=1)

    do {
        println("\n\n\n\n\n\n\n\n\nBoard width: $width")
        print("How tall would you like your board: ")
        height = getInput()
    }while(height<=1)

    do {
        println("\n\n\n\n\n\n\n\n\n\nBoard width: $width")
        println("Board height: $height")
        print("How many mines would you like: ")
        mines = getInput()
        if (mines >= (width*height)){
            mines = (width*height) -1
        }
    }while(mines<=1)

    map = MineSweeperMap(height, width, mines)

    while(playGame){
        print("Type to move - w(up) s(down) a(left) d(right) to move, e(open) to show square: ")
        parseDirection(readln())

        map!!.renderMap()
        if(map!!.checkGameStatus() == "Game over - You lose"){
            playGame = false
            println("GAME OVER ------ You Lose")
        } else if (map!!.checkGameStatus() == "Game over - You Won"){
            playGame = false
            println("GAME OVER ------ You Won!!!")
        }
    }
}

fun getInput(): Int {
    var userInput = 0

    try {
        val scanner = Scanner(System.`in`)
        userInput = scanner.nextInt()
        if (userInput <= 1){
            println("\n\n\n\n\n\n\n\n\n\nPlease enter a positive whole number > 1")
        }
    }catch (e : InputMismatchException){
        println("\n\n\n\n\n\n\n\n\n\nSorry that is an invalid entry")
    }

    return userInput
}

fun parseDirection(userInput: String) {

    val input = userInput.lowercase()
    val chars: CharArray = input.toCharArray()
    val firstChar = chars.first()
    var charCount = 0
    for (c in chars) {
        if (c != firstChar) {
            charCount = -1
            map?.setErrorMsg("Invalid direction please try again")
        } else{
            charCount++
        }
    }

    if(charCount >= 0){
        when (chars.first()) {
            'w' -> map?.updatePlayerPos("up", charCount)
            's' -> map?.updatePlayerPos("down", charCount)
            'a' -> map?.updatePlayerPos("left", charCount)
            'd' -> map?.updatePlayerPos("right", charCount)
            ' ' -> map?.updatePlayerPos("open", charCount)
            'p' -> playGame = false
            else -> map?.setErrorMsg("Invalid direction please try again")
        }
    }
}