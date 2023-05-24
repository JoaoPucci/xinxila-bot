package command.waifu.repository

import kotlinx.coroutines.flow.flow

class AnimeGirlHoldingProgrammingBooksRepositoryImpl() : AnimeGirlHoldingProgrammingBooksRepository {

    override suspend fun fetchKotlinGirl() = flow {
        emit("here your anime girl nyan nyan")
    }
}