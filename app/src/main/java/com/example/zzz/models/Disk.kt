package com.example.zzz.models

class Disk(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val diskType: String
) : LibraryItem(id, isAvailable, name) {
    override fun getBriefInfo() = "$diskType $name доступна: ${if (isAvailable) "Да" else "Нет"}"
    override fun getDetailedInfo() = "$diskType $name доступна: ${if (isAvailable) "Да" else "Нет"}"
}
