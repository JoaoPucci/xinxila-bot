package tech.pucci.waifu.repository

import io.ktor.client.statement.bodyAsChannel
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tech.pucci.exception.FileExtensionNotProvidedException
import tech.pucci.exception.NetworkErrorException
import tech.pucci.waifu.api.AnimeGirlsWithBooksApi
import tech.pucci.waifu.model.AnimeGirlsWithBookResponse

class AnimeGirlsWithBooksRepositoryImpl(
    private val animeGirlsWithBooksApi: AnimeGirlsWithBooksApi
) : AnimeGirlsWithBooksRepository {

    override suspend fun fetchRandomWaifu(): Flow<Result<AnimeGirlsWithBookResponse>> = flow {
        try {
            val response = animeGirlsWithBooksApi.getRandomWaifu()
            val fileExtension = response.contentType()?.contentSubtype ?: throw FileExtensionNotProvidedException()
            val animeGirlResponse = AnimeGirlsWithBookResponse(fileExtension, response.bodyAsChannel())

            emit(Result.success(animeGirlResponse))
        } catch (e: FileExtensionNotProvidedException) {
            emit(Result.failure(e))
        } catch (e: Exception) {
            emit(Result.failure(NetworkErrorException(e)))
        }
    }
}