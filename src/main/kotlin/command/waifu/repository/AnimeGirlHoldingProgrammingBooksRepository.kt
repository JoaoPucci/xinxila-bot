package command.waifu.repository

import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.flow.Flow

interface AnimeGirlHoldingProgrammingBooksRepository {

    suspend fun fetchRandomWaifu(): Flow<Pair<String, ByteReadChannel>>
}