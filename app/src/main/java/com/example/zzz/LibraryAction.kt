package com.example.zzz

interface LibraryAction {
    fun getBriefInfo(): String  // кратко
    fun getDetailedInfo(): String  // подробно
    // действия
    fun takeHome()
    fun readInHall()
    fun returnItem()
}
