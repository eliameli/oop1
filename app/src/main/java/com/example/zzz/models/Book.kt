package com.example.zzz.models

import com.example.zzz.LibraryAction

class Book(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val author: String,
    val pages: Int
) : LibraryItem(id, isAvailable, name), LibraryAction {

    override fun getBriefInfo() = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun getDetailedInfo() = "Книга: $name ($pages стр.) автора: $author с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun takeHome(): String {
        return if (isAvailable) {
            isAvailable = false
            "$name взята домой."
        } else {
            "$name недоступна для взятия домой."
        }
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