package tech.pucci.module

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module
import tech.pucci.client.GenericHttpClient
import tech.pucci.client.KtorHttpClient

val networkModule = module {
    factory<GenericHttpClient> { KtorHttpClient(HttpClient(CIO)) }
}