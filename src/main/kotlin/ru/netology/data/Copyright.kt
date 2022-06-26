package ru.netology.data

import Comments
import ru.netology.domain.Attachment


class Copyright (
    val id: Int,
    val link: String,
    val name: String,
    val type: String
) {
    operator fun compareTo(toString: Int): Int { TODO() }
    operator fun plus(any: Any): Copyright? { TODO() }

    constructor() : this(4, "1", "2", "3")
}

class Post1(

    var id: Int,
    val date: Int,
    var ownerId: Int,
    var fromId: Int,
    val createdBy: Int,
    val authorName: String,
    val text: String?,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Int,
    var comments: Comments?,
    copyright: Copyright?,
    var reposts: Repost?,
    val views: Long,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Int,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Int,
    var items: Array<Attachment>,
    var original: Post?,
    likes : Likes?,

    ) {

    var copyright = copyright
        set(value) {
            if (value != null) {
                if (value < 0) {
                    return
                }
            }
            field = value
        }
        get() = field?.plus((original?.copyright ?: 0))
}


fun copyrightfun(post: Post) {
    var copyright = post.copyright ?: post

}
