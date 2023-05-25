package command.waifu.repository

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimeGirlHoldingProgrammingBooksRepositoryImpl() : AnimeGirlHoldingProgrammingBooksRepository {

    val client = HttpClient(CIO)

    override suspend fun fetchRandomWaifu(): Flow<Pair<String, ByteReadChannel>> = flow {
        val response: HttpResponse = client.request {
//            url("https://media.tenor.com/eez8bOaGsMIAAAAi/anime-girl.gif")
            url("http://localhost:3000/api")
            method = HttpMethod.Get
        }

        val fileExtension = response.contentType()?.contentSubtype ?: "any"

        emit(".$fileExtension" to response.bodyAsChannel())
    }
}