package com.example.zzz.models

import com.example.zzz.LibraryAction

class Newspaper(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val issueNumber: Int
) : LibraryItem(id, isAvailable, name) {

    override fun getBriefInfo(): String = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"
    override fun getDetailedInfo(): String = "Выпуск: $issueNumber газеты $name с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"
}