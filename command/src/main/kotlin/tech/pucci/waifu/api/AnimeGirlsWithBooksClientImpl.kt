package tech.pucci.waifu.api

import tech.pucci.client.GenericHttpClient

class AnimeGirlsWithBooksClientImpl(private val httpClient: GenericHttpClient) : AnimeGirlsWithBooksClient {

    companion object {
        private const val BASE_URL = "http://localhost:3000"
        private const val GET_RANDOM_ENDPOINT = "$BASE_URL/api"
    }

    override suspend fun getRandomWaifu() = httpClient.get(GET_RANDOM_ENDPOINT)
}