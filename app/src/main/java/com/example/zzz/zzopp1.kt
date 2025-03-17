package com.example.zzz
import com.example.zzz.models.Book
import com.example.zzz.models.Newspaper
import com.example.zzz.models.Disk
import com.example.zzz.libra.Library
import com.example.zzz.LibraryAction

fun main() {
    // создание элементов
    val items = listOf(
        Book(1, true, "Маугли", "Джозеф Киплинг", 202),
        Book(11, true, "Звездные войны", "Джордж Лукас", 401),
        Newspaper(2, true, "Сельская жизнь", 794),
        Newspaper(21, true, "Семья", 23),
        Disk(3, true, "Дэдпул и Росомаха", "DVD"),
        Disk(31, true, "Один Дома", "CD")
    )

    // запуск
    Library(items).start()
}



