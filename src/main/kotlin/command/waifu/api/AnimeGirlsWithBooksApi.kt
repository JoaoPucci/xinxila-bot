package command.waifu.api

import io.ktor.client.statement.HttpResponse

interface AnimeGirlsWithBooksApi {

    suspend fun getRandomWaifu(): HttpResponse
}