package com.example.zzz.models

import com.example.zzz.LibraryAction

class Book(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val author: String,
    val pages: Int
) : LibraryItem(id, isAvailable, name) {

    override fun getBriefInfo(): String = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"
    override fun getDetailedInfo(): String = "Книга: $name ($pages стр.) автора: $author с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"
}