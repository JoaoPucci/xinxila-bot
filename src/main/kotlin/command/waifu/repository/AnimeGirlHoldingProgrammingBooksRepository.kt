package command.waifu.repository

import kotlinx.coroutines.flow.Flow

interface AnimeGirlHoldingProgrammingBooksRepository {

    suspend fun fetchKotlinGirl(): Flow<String>
}