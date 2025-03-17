package com.example.zzz.models

class Book(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val author: String,
    val pages: Int
) : LibraryItem(id, isAvailable, name) {
    override fun getBriefInfo() = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"
    override fun getDetailedInfo() = "Книга: $name ($pages стр.) автора: $author с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"
}