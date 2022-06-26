package ru.netology.service


interface GlobalService<E> {


    fun add(element: E): E
    fun getByID(id: Int): E
    fun edit(element: E): Boolean
    fun restore(id: Int): Boolean
    fun delete(id: Int): Boolean


}

