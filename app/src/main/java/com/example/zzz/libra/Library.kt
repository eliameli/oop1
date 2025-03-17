package com.example.zzz.libra


import com.example.zzz.models.LibraryItem
import com.example.zzz.LibraryAction

class Library(private val items: List<LibraryItem>) {

    // запуск библиотеки
    fun start() {
        while (true) {
            println("Выберите тип объекта:\n1. Показать книги\n2. Показать газеты\n3. Показать диски\n0. Выход")
            when (readLine()?.toIntOrNull()) {
                1 -> showItems(items.filterIsInstance<LibraryAction>())
                2 -> showItems(items.filterIsInstance<LibraryAction>())
                3 -> showItems(items.filterIsInstance<LibraryAction>())
                0 -> return
                else -> println("Неверный выбор.")
            }
        }
    }

    // список
    private fun <T : LibraryAction> showItems(items: List<T>) {
        items.forEachIndexed { index, item -> println("${index + 1}. ${item.getBriefInfo()}") }
        println("Выберите объект (номер) или 0 для возврата в меню:")
        val objectNumber = readLine()?.toIntOrNull()

        if (objectNumber == 0) return

        if (objectNumber != null && objectNumber in 1..items.size) {
            performAction(items[objectNumber - 1])
        } else {
            println("Неверный номер объекта.")
        }
    }

    // выполнение действий
    private fun performAction(item: LibraryAction) {
        println("Выберите действие:\n1. Взять домой\n2. Читать в читальном зале\n3. Показать подробную информацию\n0. Вернуться в меню")
        when (readLine()?.toIntOrNull()) {
            1 -> println(item.takeHome())
            2 -> println(item.readInHall())
            3 -> println(item.getDetailedInfo())
            0 -> return
            else -> println("Неверный выбор.")
        }
    }
}