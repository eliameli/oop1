package com.example.zzz.models

import com.example.zzz.LibraryAction

class Newspaper(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val issueNumber: Int
) : LibraryItem(id, isAvailable, name), LibraryAction {

    override fun getBriefInfo(): String = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun getDetailedInfo(): String =
        "Выпуск: $issueNumber газеты $name с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun takeHome() {
        println("Газету $name нельзя взять домой.")
    }

    override fun readInHall() {
        if (isAvailable) {
            isAvailable = false
            println("Газету $name можно читать в читальном зале.")
        } else {
            println("Газета $name недоступна для чтения в зале.")
        }
    }

    override fun returnItem() {
        if (!isAvailable) {
            isAvailable = true
            println("Газета $name возвращена.")
        } else {
            println("Газета $name уже доступна.")
        }
    }
}
