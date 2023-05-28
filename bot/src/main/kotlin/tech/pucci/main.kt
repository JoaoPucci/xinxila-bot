import command.module.commandModule
import tech.pucci.module.eventHandlerModule
import tech.pucci.module.networkModule
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import tech.pucci.bot.DiscordBot
import tech.pucci.module.discordModule

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