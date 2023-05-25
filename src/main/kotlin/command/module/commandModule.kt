package command.module

import command.ping.PingCommand
import command.waifu.WaifuCommand
import command.waifu.repository.AnimeGirlsWithBooksRepository
import command.waifu.repository.AnimeGirlsWithBooksRepositoryImpl
import command.waifu.api.AnimeGirlsWithBooksApi
import command.waifu.api.AnimeGirlsWithBooksApiImpl
import org.koin.dsl.module

val commandModule = module {
    factory { PingCommand() }
    factory<AnimeGirlsWithBooksApi> { AnimeGirlsWithBooksApiImpl(get()) }
    factory<AnimeGirlsWithBooksRepository> { AnimeGirlsWithBooksRepositoryImpl(get()) }
    factory { WaifuCommand(repository = get()) }
}