import ru.netology.data.Likes
import ru.netology.data.Post

class WallService(

    var original1: Post,
    var original2: Post,
    var original3: Post,
    postArray: Array<Post> = arrayOf(original1, original2, original3),

    ) {

    init {
        postArray[0] = original1
        postArray[1] = original2
        postArray[2] = original3

    }


    var posts: Array<Post> = arrayOf(original1, original2, original3)
    val comm1 = Comments(2, 3, 4092009, "популярный пост", 5, 7, true)
    val comm2 = Comments(2, 3, 4092009, "популярный пост", 5, 7, true)
    val comm3 = Comments(2, 3, 4092009, "популярный пост", 5, 7, true)
    var comments: Array<Comments> = arrayOf(comm1, comm2, comm3)


    var propertyId = 0


    fun add(post: Post): Post {
        propertyId++
        post.id = propertyId
        posts += post
        return posts.last()
    }


    fun update(post: Post, updateWork: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (item.id == post.id) {
                posts[index].ownerId = updateWork.ownerId
                posts[index].fromId = updateWork.fromId
                return true
            }
        }
        return false
    }


    fun createComment(postId: Int, comment: Comments): Comments {
        try {
            for (post in posts) {
                println(post.id)
                if (post.id == postId) {
                    comments[postId] = comment
                    println("id совпадает")
                } else {
                    throw PostNotFoundException()
                }
            }
        } catch (e: PostNotFoundException) {
            println("id не совпадает")

        }
        return comment
    }
}

private fun <T> Array<T>.copy(likes: Likes) {}

