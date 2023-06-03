package tech.pucci.waifu.network.repository

import kotlinx.coroutines.flow.Flow
import tech.pucci.waifu.model.AnimeGirlsWithBookResponse

interface AnimeGirlsWithBooksRepository {

    suspend fun fetchRandomWaifu(): Flow<Result<AnimeGirlsWithBookResponse>>
}