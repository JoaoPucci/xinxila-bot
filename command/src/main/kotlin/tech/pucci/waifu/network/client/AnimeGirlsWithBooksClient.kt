package tech.pucci.waifu.network.client

import io.ktor.client.statement.HttpResponse

interface AnimeGirlsWithBooksClient {

    suspend fun getRandomWaifu(): HttpResponse
}