package tech.pucci.client

import io.ktor.client.HttpClient
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.HttpMethod

class KtorHttpClient(private val ktor: HttpClient) : GenericHttpClient {
    override suspend fun get(url: String) = ktor.request {
        url(url)
        method = HttpMethod.Get
    }
}