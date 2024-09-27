package menu

import data.EntityType
import java.util.Scanner

object MainMenu : Menu() {

    fun open() {
        while (true) {
            printMenu(EntityType.ARCHIVE, null)
            val input = Scanner(System.`in`).nextLine()
            if (validateNumInputIsNotCorrect(input)) {
                continue
            }

            when (input.toInt()) {
                0 -> {
                    println("Завершение программы")
                    break
                }

                1 -> {
                    addEntityToRepo(EntityType.ARCHIVE, null)
                }

                else -> {
                    openNextMenu(input.toInt(), EntityType.ARCHIVE)
                }
            }
        }
    }
}