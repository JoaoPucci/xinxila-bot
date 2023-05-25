package command.waifu.repository

import command.waifu.model.AnimeGirlsWithBookResponse
import kotlinx.coroutines.flow.Flow

interface AnimeGirlsWithBooksRepository {

    suspend fun fetchRandomWaifu(): Flow<Result<AnimeGirlsWithBookResponse>>
}