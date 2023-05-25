import command.module.commandModule
import discord.bot.DiscordBot
import discord.module.discordModule
import eventhandler.module.eventHandlerModule
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin

suspend fun main() {

    startKoin {
        modules(
            listOf(
                networkModule,
                commandModule,
                eventHandlerModule,
                discordModule
            )
        )
    }

    val discordBot: DiscordBot = GlobalContext.get().get()
    discordBot.initialize()
}