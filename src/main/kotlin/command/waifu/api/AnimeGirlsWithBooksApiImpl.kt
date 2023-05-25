package command.waifu.api

import io.ktor.client.HttpClient
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod

class AnimeGirlsWithBooksApiImpl(private val client: HttpClient) : AnimeGirlsWithBooksApi {

    companion object {
        private const val BASE_URL = "http://localhost:3000/api"
    }

    override suspend fun getRandomWaifu(): HttpResponse {
        return client.request {
            url(BASE_URL)
            method = HttpMethod.Get
        }
    }
}