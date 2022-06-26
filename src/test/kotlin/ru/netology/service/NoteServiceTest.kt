package ru.netology.service

import org.junit.Assert.*
import org.junit.Test
import ru.netology.data.Note

class NoteServiceTest {

    @org.junit.Before
    fun setUp() {
    }

    @org.junit.After
    fun tearDown() {
        NoteService().clear()
    }

    @Test
    fun add() {
        val expectedId = 1
        val note = Note(0, "Заметка", "Текст", true)
        val actualId = NoteService().add(note)
        assertEquals(expectedId, actualId.id)
    }

    @Test
    fun delete() {
        val expectedChange = false
        val note = Note(0, "Заметка", "Текст", false)
        val actualChange = NoteService().delete(note.id)
        assertEquals(expectedChange, actualChange)
    }

    @Test
    fun edit() {
        val expectedChange = false
        val note = Note(0, "Заметка", "Текст", false)
        val actualChange = NoteService().edit(note)
        assertEquals(expectedChange, actualChange)
    }

    @Test
    fun getByID() {
        val note = Note(1, "Заметка", "Текст", false)
        val noteService = NoteService()
        noteService.elementsList.add(0, note)
        println(noteService.elementsList.size)
        val expectedId = 1
        val actualNote = noteService.getByID(1)
        assertEquals(expectedId, actualNote.id)
    }

    @Test
    fun restore() {

        val noteService = NoteService()
        val note = Note(1, "Заметка", "Текст", false)
        val expectedChange = false
        val actualChange = noteService.restore(1)
        assertEquals(expectedChange, actualChange)
    }
}

