package discord

import dev.kord.core.Kord
import eventhandler.MessageCreateEventHandler
import kotlinx.coroutines.runBlocking
import org.koin.dsl.module

val discordModule = module {
    runBlocking {
        val kord = Kord(GetBotAuthTokenUseCaseImpl().token)
        factory { kord }
        factory { MessageCreateEventHandler(pingCommand = get(), waifuCommand = get()) }
        factory<DiscordBot> { DiscordBotImpl(kord = get(), messageCreateEventHandler = get()) }
    }
}