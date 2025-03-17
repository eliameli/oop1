package com.example.zzz.models

class Newspaper(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val issueNumber: Int
) : LibraryItem(id, isAvailable, name) {
    override fun getBriefInfo() = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"
    override fun getDetailedInfo() = "Выпуск: $issueNumber газеты $name с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"
}