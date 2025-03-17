package com.example.zzz.models

import com.example.zzz.LibraryAction

class Disk(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val diskType: String
) : LibraryItem(id, isAvailable, name), LibraryAction {

    override fun getBriefInfo() = "$diskType $name доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun getDetailedInfo() = "$diskType $name доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun takeHome(): String {
        return if (isAvailable) {
            isAvailable = false
            "$name взят домой."
        } else {
            "$name недоступен для взятия домой."
        }
    }

    override fun readInHall(): String {
        return "Нельзя пользоваться диском в читальном зале."
    }
}