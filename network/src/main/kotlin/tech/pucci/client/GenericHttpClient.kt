package tech.pucci.client

import io.ktor.client.statement.HttpResponse

interface GenericHttpClient {

    suspend fun get(url: String): HttpResponse
}