package ru.netology.domain


abstract class Attachment(val type: String)

class VideoAttachment(
    val id: Int,
    val owner_id: Int,
    val title: String,
    val duration: Int,
    val video_url: String
): Attachment("video")

class PhotoAttachment(
    val id: Int,
    val album_id: Int,
    val owner_id: Int,
    val user_id: Int,
    val photo_url: String
): Attachment("photo")

class AudioAttachment(
    val id: Int,
    val owner_id: Int,
    val artist: String,
    val title: String,
    val audio_url: String
): Attachment("audio")

class FileAttachment(
    val id: Int,
    val owner_id: Int,
    val title: String,
    val size: Int,
    val file_url: String
): Attachment("file")

class GraffitiAttachment(
    val id: Int,
    val owner_id: Int,
    val width: Int,
    val height: Int,
    val graffiti_url: String
): Attachment("graffiti")

fun showAttachment(attachment: String, type: Any) {
    when (type) {
        "video" -> (attachment as VideoAttachment).video_url
        "photo" -> (attachment as PhotoAttachment).photo_url
        "audio" -> (attachment as AudioAttachment).audio_url
        "file" -> (attachment as FileAttachment).file_url
        "graffiti" -> (attachment as GraffitiAttachment).graffiti_url

    }
}
