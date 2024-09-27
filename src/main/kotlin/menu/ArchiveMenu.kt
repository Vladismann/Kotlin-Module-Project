package menu

import data.EntityType
import java.util.Scanner

object ArchiveMenu : Menu() {

    fun open(archiveName: String) {
        while (true) {
            printMenu(EntityType.NOTE, null)
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
                    /*if (input.toInt() - 1 <= archiveRepo.size) {
                        //ArchiveMenu.open(actualRepo[input.toInt() - 2])
                    } else {
                        println("Укажите существующий архив")
                    }*/
                }
            }
        }
    }

}
