package tech.pucci.module

import dev.kord.core.Kord
import kotlinx.coroutines.runBlocking
import org.koin.dsl.module
import tech.pucci.bot.DiscordBot
import tech.pucci.bot.DiscordBotImpl
import tech.pucci.usecase.GetBotAuthTokenUseCaseImpl

val discordModule = module {
    runBlocking {
        val kord = Kord(GetBotAuthTokenUseCaseImpl().token)
        factory { kord }
        factory<DiscordBot> { DiscordBotImpl(kord = get(), messageCreateEventHandler = get()) }
    }
}