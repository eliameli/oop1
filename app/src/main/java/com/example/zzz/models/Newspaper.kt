package com.example.zzz.models

import com.example.zzz.LibraryAction

class Newspaper(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val issueNumber: Int
) : LibraryItem(id, isAvailable, name), LibraryAction {

    override fun getBriefInfo() = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun getDetailedInfo() = "Выпуск: $issueNumber газеты $name с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun takeHome(): String {
        return "Газету нельзя взять домой."
    }

    override fun readInHall(): String {
        return if (isAvailable) {
            isAvailable = false
            "$name можно читать в читальном зале."
        } else {
            "$name недоступна для чтения в зале."
        }
    }
}