package ru.netology.data


open class Post(

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
    var comments: Unit,
    var copyright: Copyright?,
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
    var items: Unit,
    var original: Post?,
    likes: Likes,

    ) {
    fun copy(likes: Likes) {
    }


    var likes = likes
        set (value) {
            if (value < 0) {
                return
            }
            field = value
        }
        get() = field + (original?.likes ?: 0)
}
