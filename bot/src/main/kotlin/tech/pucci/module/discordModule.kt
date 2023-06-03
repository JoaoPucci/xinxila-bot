package tech.pucci.module

import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import kotlinx.coroutines.runBlocking
import org.koin.dsl.module
import tech.pucci.EventHandler
import tech.pucci.MessageCreateEventHandler
import tech.pucci.bot.DiscordBot
import tech.pucci.bot.DiscordBotImpl
import tech.pucci.discord.DiscordApi
import tech.pucci.discord.DiscordKord
import tech.pucci.usecase.GetBotAuthTokenUseCaseImpl

val discordModule = module {
    runBlocking {
        val kord = Kord(GetBotAuthTokenUseCaseImpl().token)
        factory { kord }

        factory<EventHandler<MessageCreateEvent>> {
            MessageCreateEventHandler(
                pingCommand = get(),
                waifuCommand = get()
            )
        }

        factory<DiscordApi> { DiscordKord(kord = get(), messageCreateEventHandler = get()) }
        factory<DiscordBot> { DiscordBotImpl(get()) }
    }
}