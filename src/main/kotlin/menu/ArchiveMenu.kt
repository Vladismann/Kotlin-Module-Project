package menu

import data.EntityType
import java.util.Scanner

object ArchiveMenu : Menu() {

    fun open(archiveName: String) {
        while (true) {
            printMenu(EntityType.NOTE, archiveName)
            val input = Scanner(System.`in`).nextLine()
            if (validateNumInputIsNotCorrect(input)) {
                continue
            }

            when (input.toInt()) {
                0 -> {
                    println("Возврат в главное меню")
                    break
                }

                1 -> {
                    addEntityToRepo(EntityType.NOTE, archiveName)
                }

                else -> {
                    openNextMenu(input.toInt(), EntityType.NOTE, archiveName)
                }
            }
        }
    }

}
