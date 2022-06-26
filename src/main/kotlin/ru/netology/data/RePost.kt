package ru.netology.data



open class Repost(

    val id: Int,
    val date: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val authorName: String,
    val text: String?,
    var likes: Int
){

    constructor() : this(8,  4122003, 1, 3, 5, "Специалист", "Новый специалист",  34)
}

fun repost(post: Post) {
    var repost = post.reposts ?: post

}

