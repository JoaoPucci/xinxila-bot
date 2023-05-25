package command.waifu.model

import io.ktor.utils.io.ByteReadChannel

data class AnimeGirlsWithBookResponse(
    val fileExtension: String,
    val image: ByteReadChannel
)