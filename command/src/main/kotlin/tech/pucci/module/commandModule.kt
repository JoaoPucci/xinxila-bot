package command.module

import command.ping.PingCommand
import tech.pucci.waifu.WaifuCommand
import tech.pucci.waifu.api.AnimeGirlsWithBooksApi
import tech.pucci.waifu.api.AnimeGirlsWithBooksApiImpl
import tech.pucci.waifu.repository.AnimeGirlsWithBooksRepository
import tech.pucci.waifu.repository.AnimeGirlsWithBooksRepositoryImpl
import org.koin.dsl.module

val commandModule = module {
    factory { PingCommand() }
    factory<AnimeGirlsWithBooksApi> { AnimeGirlsWithBooksApiImpl(get()) }
    factory<AnimeGirlsWithBooksRepository> { AnimeGirlsWithBooksRepositoryImpl(get()) }
    factory { WaifuCommand(repository = get()) }
}