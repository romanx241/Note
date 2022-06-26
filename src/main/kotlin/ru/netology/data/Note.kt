package ru.netology.data

data class Note(
    val id: Int,
    val title: String,
    val text: String,
    val isDeleted: Boolean
) {
    constructor() : this(0, "Заметка", "Текст", false)
}