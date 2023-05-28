package tech.pucci.waifu.repository

import io.ktor.client.statement.bodyAsChannel
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tech.pucci.exception.FileExtensionNotProvidedException
import tech.pucci.exception.NetworkErrorException
import tech.pucci.waifu.api.AnimeGirlsWithBooksClient
import tech.pucci.waifu.model.AnimeGirlsWithBookResponse

class AnimeGirlsWithBooksRepositoryImpl(
    private val client: AnimeGirlsWithBooksClient
) : AnimeGirlsWithBooksRepository {

    override suspend fun fetchRandomWaifu(): Flow<Result<AnimeGirlsWithBookResponse>> = flow {
        try {
            val response = client.getRandomWaifu()
            val fileExtension = response.contentType()?.contentSubtype ?: throw FileExtensionNotProvidedException()
            val animeGirlResponse = AnimeGirlsWithBookResponse(fileExtension, response.bodyAsChannel())

            emit(Result.success(animeGirlResponse))
        } catch (e: NetworkErrorException) {
            emit(Result.failure(e))
        }
    }
}