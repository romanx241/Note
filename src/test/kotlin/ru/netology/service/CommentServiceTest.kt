package ru.netology.service

import Comments
import comment
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class CommentServiceTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
        CommentService().clear()
    }


    @Test
    fun add() {
        val commentService = CommentService()
        val comments = Comments(1, 3, 4092009, "популярный пост", 5, 7, true)
        val expectedCom = comment()
        val actualCom = commentService.elementsList.add(0, comments)
        assertEquals(expectedCom, actualCom)
    }



    @Test
    fun delete() {
        val expectedChange = false
        val comments = Comments(1, 3, 4092009, "популярный пост", 5, 7, true)
        val actualChange = CommentService().delete(comments.id)
        assertEquals(expectedChange, actualChange)
    }

    @Test
    fun edit() {
        val expectedChange = false
        val comments = Comments(1, 3, 4092009, "популярный пост", 5, 7, true)
        val actualChange = CommentService().edit(comments)
        assertEquals(expectedChange, actualChange)
    }


    @Test
    fun restore() {
        val commentService = CommentService()
        val expectedIsChange = false
        val actualIsChange = commentService.restore(0)
        assertEquals(expectedIsChange, actualIsChange)
    }
}
