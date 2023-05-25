package command.waifu.repository

import command.waifu.api.AnimeGirlsWithBooksApi
import command.waifu.model.AnimeGirlsWithBookResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import network.exception.NetworkErrorException
import network.exception.FileExtensionNotProvidedException

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