package command.module

import command.ping.PingCommand
import command.waifu.WaifuCommand
import command.waifu.repository.AnimeGirlHoldingProgrammingBooksRepository
import command.waifu.repository.AnimeGirlHoldingProgrammingBooksRepositoryImpl
import org.koin.dsl.module

val commandModule = module {
    factory { PingCommand() }

    factory<AnimeGirlHoldingProgrammingBooksRepository> { AnimeGirlHoldingProgrammingBooksRepositoryImpl() }
    factory { WaifuCommand(repository = get()) }
}