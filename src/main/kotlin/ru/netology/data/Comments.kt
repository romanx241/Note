import ru.netology.PostNotFoundException
import ru.netology.data.Copyright
import ru.netology.data.Post
import ru.netology.data.Likes

import ru.netology.data.Repost
import ru.netology.domain.Attachment

data class Comments(

    var id: Int,   //Идентификатор комментария.
    val from_id: Int,   //Идентификатор автора комментария.
    val data: Int,    //Дата создания комментария в формате Unixtime.
    var text: String,   //Текст комментария.
    val reply_to_user: Int,   //Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    val reply_to_comment: Int,  //Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val isDeleted: Boolean
) {
    constructor() : this(2, 3, 4092009, "популярный пост", 5, 7, true)
}

class Post(

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
    comments: Array<Comments>,
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
    var items: Array<Attachment>,
    var original: Post?,
    var likes : Likes?,
    var original1: Post,
    var original2: Post,
    var original3: Post,
    var posts: Array<Post> = arrayOf(original1, original2, original3)
) {




    fun comment(post: Post) {
        var comments = ((post.comments ?: post) as Comments?)

    }

    val comm1 = Comments(1, 4, 4092009, "популярный пост1", 5, 9, true)
    val comm2 = Comments(2, 5, 4092009, "популярный пост2", 6, 6, true)
    val comm3 = Comments(3, 6, 4092009, "популярный пост3", 7, 4, true)

    val comments: Array<Comments> = arrayOf(comm1, comm2, comm3)



}