package tech.pucci.module

import tech.pucci.ping.PingCommand
import org.koin.dsl.module
import tech.pucci.waifu.WaifuCommand
import tech.pucci.waifu.network.client.AnimeGirlsWithBooksClient
import tech.pucci.waifu.network.client.AnimeGirlsWithBooksClientImpl
import tech.pucci.waifu.network.repository.AnimeGirlsWithBooksRepository
import tech.pucci.waifu.network.repository.AnimeGirlsWithBooksRepositoryImpl

val commandModule = module {
    factory { PingCommand() }
    factory<AnimeGirlsWithBooksClient> { AnimeGirlsWithBooksClientImpl(get()) }
    factory<AnimeGirlsWithBooksRepository> { AnimeGirlsWithBooksRepositoryImpl(get()) }
    factory { WaifuCommand(repository = get()) }
}