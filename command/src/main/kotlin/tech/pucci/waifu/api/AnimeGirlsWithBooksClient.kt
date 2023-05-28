package tech.pucci.waifu.api

import io.ktor.client.statement.HttpResponse

interface AnimeGirlsWithBooksClient {

    suspend fun getRandomWaifu(): HttpResponse
}