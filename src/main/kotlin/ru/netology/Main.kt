import ru.netology.data.*
import ru.netology.data.Post
import ru.netology.domain.Attachment
import ru.netology.service.CommentService
import ru.netology.service.NoteService


val Unit.id: Any
    get() {
        TODO()
    }



fun main() {


    val original1 = Post(
        id = 1,
        date = 4122003,
        ownerId = 1,
        fromId = 1,
        createdBy = 1590075360,
        authorName = "Нетология",
        text = "Новая Нетология",
        replyOwnerId = 2,
        replyPostId = 3,
        friendsOnly = 5,
        comments = Array<Comments>(),
        copyright = Copyright(1, " ", " ", " "),
        reposts = Repost(1, 4122003, 3, 4, 5, "Нетология", "Новая Нетология", 22),
        views = 30,
        postType = "copy",
        signerId = 5,
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = 2,
        markedAsAds = true,
        isFavorite = true,
        postponedId = 6,
        items = Array<Attachment>(),
        original = null,
        likes = Likes(4, true, true, false)
    )

    val original2 = Post(
        id = 2,
        date = 4122003,
        ownerId = 6,
        fromId = 7,
        createdBy = 1590075360,
        authorName = "Нетология",
        text = "Новая Нетология",
        replyOwnerId = 2,
        replyPostId = 3,
        friendsOnly = 5,
        comments = Array<Comments>(),
        copyright = Copyright(1, " ", " ", " "),
        reposts = Repost(1, 4122003, 3, 4, 5, "Нетология", "Новая Нетология", 21),
        views = 30,
        postType = "copy",
        signerId = 5,
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = 2,
        markedAsAds = true,
        isFavorite = true,
        postponedId = 6,
        items = Array<Attachment>(),
        original = null,
        likes = Likes(4, true, true, false)
    )

    val original3 = Post(
        id = 0,
        date = 4122003,
        ownerId = 5,
        fromId = 2,
        createdBy = 1590075360,
        authorName = "Нетология",
        text = "Новая Нетология",
        replyOwnerId = 2,
        replyPostId = 3,
        friendsOnly = 5,
        comments = Array<Comments>(),
        copyright = Copyright(1, " ", " ", " "),
        reposts = Repost(1, 4122003, 3, 4, 5, "Нетология", "Новая Нетология", 20),
        views = 30,
        postType = "copy",
        signerId = 5,
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = 2,
        markedAsAds = true,
        isFavorite = true,
        postponedId = 6,
        items = Array<Attachment>(),
        original = null,
        likes = Likes(4, true, true, false)
    )
    val updateWork = Post(
        id = 5,
        date = 4122003,
        ownerId = 100,
        fromId = 150,
        createdBy = 1590075360,
        authorName = "Нетология",
        text = "Новая Нетология",
        replyOwnerId = 2,
        replyPostId = 3,
        friendsOnly = 5,
        comments = Array<Comments>(),
        copyright = Copyright(1, " ", " ", " "),
        reposts = Repost(1, 4122003, 3, 4, 5, "Нетология", "Новая Нетология", 21),
        views = 30,
        postType = "copy",
        signerId = 5,
        canPin = true,
        canDelete = false,
        canEdit = true,
        isPinned = 2,
        markedAsAds = true,
        isFavorite = true,
        postponedId = 6,
        items = Array<Attachment>(),
        original = null,
        likes = Likes(4, userLikes = true, canLikes = true, canPublish = false)
    )



    val wallService = WallService(original1, original2, original3)

    wallService.update(original1, updateWork)


    val noteService = NoteService()

    val notes = Note()
    val note1 = noteService.add(notes)
    val note2 = noteService.add(notes)
    val note3 = noteService.add(notes)





}



fun postArray(fromId: Int) {}

fun showAttachment(attachment: Post) {}

fun comment() {}

fun <T> Array() {}


open class PostNotFoundException() : RuntimeException() {}


