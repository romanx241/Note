package ru.netology.service

import ru.netology.CommentException
import ru.netology.data.Note


class NoteService : GlobalService<Note> {

    val elementsList = mutableListOf<Note>()
    private var nextID = 1


    override fun add(element: Note): Note {
        val newNote = element.copy(id = nextID++)
        elementsList.add(newNote)
        return elementsList.last()
    }

    override fun getByID(id: Int): Note {
        val listByID = mutableListOf<Note>()
        for (note in elementsList) {
            if (id == note.id && !note.isDeleted)
                listByID.add(note)
        }
        return if (listByID.isNotEmpty()) listByID.last() else throw CommentException("По этому id нет записи")
    }

    override fun edit(element: Note): Boolean {
        var isChange = false
        for ((index, value) in elementsList.withIndex()) {
            if (element.id == value.id && !value.isDeleted) {
                elementsList[index] = value.copy(
                    title = element.title,
                    text = element.text
                )
                isChange = true
                break
            }
        }
        return isChange
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

    override fun delete(id: Int): Boolean {
        var isChange = false
        val comment = CommentService()
        for ((index, value) in elementsList.withIndex()) {
            if (id == value.id && !value.isDeleted) {
                elementsList[index] = value.copy(isDeleted = true)
                if (comment.elementsList.isNotEmpty()) {
                    val commentIsDelete = comment.elementsList[index]
                    comment.elementsList[index] = commentIsDelete.copy(isDeleted = true)
                }
                isChange = true
                break
            }
        }
        return isChange
    }

    fun clear() {
        elementsList.clear()
    }
}

