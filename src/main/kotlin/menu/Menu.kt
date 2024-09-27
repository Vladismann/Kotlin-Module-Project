package menu

import data.Archive
import data.Entity
import data.EntityType
import data.Note
import data.Repo
import java.util.Scanner

abstract class Menu {

    protected fun validateNumInputIsNotCorrect(input: String): Boolean {
        return if (input.toIntOrNull() == null || input.toInt() < 0) {
            println("Введите корректное значение")
            true
        } else false

    }

    private fun validateInputIsNotEmpty(input: String): Boolean {
        return if (input.isBlank()) {
            println("Ввод не может быть пустым")
            false
        } else true
    }

    protected fun printMenu(type: EntityType, archiveName: String?) {
        val elements: MutableList<out Entity> = when (type) {
            EntityType.ARCHIVE -> {
                println("Список архивов")
                println("1. Создать архив")
                Repo.archives
            }

            EntityType.NOTE -> {
                println("archiveName")
                println("1. Создать заметку")
                Repo.notes.filter { note: Note -> note.archiveName == archiveName }
                    .toMutableList()
            }
        }

        var num = 2
        for (element in elements) {
            println("${num++}. $element")
        }
        println("0. Выход")
    }

    private fun inputIsGoBack(input: String): Boolean {
        return input.lowercase() == "назад"
    }

    protected fun addEntityToRepo(entityType: EntityType, archiveName: String?) {
        var entityName: String
        while (true) {
            when (entityType) {
                EntityType.ARCHIVE -> println("Введите имя архива или введите \"назад\" для выхода")
                EntityType.NOTE -> println("Введите имя заметки или введите \"назад\" для выхода")
            }
            entityName = Scanner(System.`in`).nextLine()
            if (inputIsGoBack(entityName)) {
                break
            }
            if (validateInputIsNotEmpty(entityName)) {
                when (entityType) {
                    EntityType.ARCHIVE -> {
                        Repo.archives.add(Archive(entityName))
                        break
                    }

                    EntityType.NOTE -> {
                        Repo.notes.add(Note(entityName, archiveName!!))
                        break
                    }
                }
            }
        }
    }

    private fun checkChoosingEntityIsCorrect(input: Int, actualListSize: Int): Boolean {
        return if (input - 1 > actualListSize) {
            println("Укажите существующий пункт меню")
            false
        } else true

    }

    fun openNextMenu(input: Int, currentType: EntityType) {
        val elements: MutableList<out Entity>?
        when (currentType) {
            EntityType.ARCHIVE -> {
                elements = Repo.archives
                if (checkChoosingEntityIsCorrect(input, elements.size)) {
                    ArchiveMenu.open(elements[input - 2].name)
                }
            }

            EntityType.NOTE -> {
                //elements = Repo.notes.filter { note: Note -> note.archiveName == archiveName }
                   // .toMutableList()
            }


        }


    }
}