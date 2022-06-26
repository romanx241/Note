package ru.netology.data

open class Likes (

    var count: Int,
    val userLikes: Boolean,
    val canLikes: Boolean,
    val canPublish: Boolean,
) {
    operator fun compareTo(i: Int): Int {
        TODO()

    }

    operator fun plus(any: Any): Likes {
        TODO()

    }


    constructor() : this(4, true, false, false)
}
