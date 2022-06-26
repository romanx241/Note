package ru.netology.service

import Comments
import ru.netology.CommentException

class CommentService : GlobalService<Comments> {
    val elementsList = mutableListOf<Comments>()


    override fun add(element: Comments): Comments {
        val note = NoteService()
        for ((index, value) in note.elementsList.withIndex()) {
            when {
                value.id == element.id && !value.isDeleted && !element.isDeleted -> {
                    elementsList.add(element)
                    break
                }
                index < note.elementsList.size - 1 -> continue
                else -> break
            }
        }
        return if (elementsList.isNotEmpty()) elementsList.last() else throw CommentException("Невозможно добавить комментарий к заметке")
    }

    override fun getByID(id: Int): Comments {
        val listByID = mutableListOf<Comments>()
        for (comment in elementsList) {
            if (id == comment.id && !comment.isDeleted)
                listByID.add(comment)
        }
        return if (listByID.isNotEmpty()) listByID.last() else throw CommentException("По данному ID комментариев не найдено")
    }

    override fun restore(id: Int): Boolean {
        var isChange = false
        for ((index, value) in elementsList.withIndex()) {
            when {
                id != value.id && (index < elementsList.size - 1) -> continue
                id == value.id && value.isDeleted -> {
                    elementsList[index] = value.copy(isDeleted = false)
                    isChange = true
                    break
                }
                else -> throw CommentException("Восстановление неудаленного комментария исключено")
            }
        }
        return isChange
    }

    override fun edit(element: Comments): Boolean {
        var isChange = false
        for ((index, value) in elementsList.withIndex()) {
            when {
                element.id != value.id && (index < elementsList.size - 1) -> continue
                element.id == value.id && !value.isDeleted -> {
                    elementsList[index] = element.copy(text = element.text)
                    isChange = true
                    break
                }
                else -> throw CommentException("Редактирование исключено поскольку комментарий уже удален")
            }
        }
        return isChange
    }

    override fun delete(id: Int): Boolean {
        var isChange = false
        for ((index, value) in elementsList.withIndex()) {
            when {
                id != value.id && (index < elementsList.size - 1) -> continue
                id == value.id && !value.isDeleted -> {
                    elementsList[index] = value.copy(isDeleted = true)
                    isChange = true
                    break
                }
                else -> throw CommentException("Этот комментарий уже удален")
            }
        }
        return isChange
    }

    fun clear() {
        elementsList.clear()
    }
}