package command.module

import command.ping.PingCommand
import org.koin.dsl.module
import tech.pucci.waifu.WaifuCommand
import tech.pucci.waifu.api.AnimeGirlsWithBooksClient
import tech.pucci.waifu.api.AnimeGirlsWithBooksClientImpl
import tech.pucci.waifu.repository.AnimeGirlsWithBooksRepository
import tech.pucci.waifu.repository.AnimeGirlsWithBooksRepositoryImpl

val commandModule = module {
    factory { PingCommand() }
    factory<AnimeGirlsWithBooksClient> { AnimeGirlsWithBooksClientImpl(get()) }
    factory<AnimeGirlsWithBooksRepository> { AnimeGirlsWithBooksRepositoryImpl(get()) }
    factory { WaifuCommand(repository = get()) }
}