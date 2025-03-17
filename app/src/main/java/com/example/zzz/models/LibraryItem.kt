package com.example.zzz.models

abstract class LibraryItem(
    val id: Int,
    var isAvailable: Boolean,
    val name: String
) {
    abstract fun getBriefInfo(): String
    abstract fun getDetailedInfo(): String
}