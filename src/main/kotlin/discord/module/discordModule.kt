package discord.module

import dev.kord.core.Kord
import discord.bot.DiscordBot
import discord.bot.DiscordBotImpl
import discord.usecase.GetBotAuthTokenUseCaseImpl
import kotlinx.coroutines.runBlocking
import org.koin.dsl.module

val discordModule = module {
    runBlocking {
        val kord = Kord(GetBotAuthTokenUseCaseImpl().token)
        factory { kord }
        factory<DiscordBot> { DiscordBotImpl(kord = get(), messageCreateEventHandler = get()) }
    }
}