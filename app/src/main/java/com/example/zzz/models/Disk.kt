package com.example.zzz.models

import com.example.zzz.LibraryAction

class Disk(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val diskType: String
) : LibraryItem(id, isAvailable, name) {

    override fun getBriefInfo(): String = "$diskType $name доступна: ${if (isAvailable) "Да" else "Нет"}"
    override fun getDetailedInfo(): String = "$diskType $name доступна: ${if (isAvailable) "Да" else "Нет"}"
}