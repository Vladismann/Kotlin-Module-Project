package menu

import data.EntityType
import java.util.Scanner

object NoteMenu : Menu() {

    fun open(noteName: String) {
        while (true) {
            printMenu(EntityType.TEXT, noteName)
            val input = Scanner(System.`in`).nextLine()
            if (validateNumInputIsNotCorrect(input)) {
                continue
            }
            if (input.toInt() == 0) {
                println("Возврат в архив")
                break
            } else {
                println("Для выхода введите 0")
            }
        }
    }
}
