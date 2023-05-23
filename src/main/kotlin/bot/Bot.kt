package bot

import dev.kord.core.Kord
import dev.kord.core.event.Event
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import eventhandler.MessageCreateEventHandler

class Bot {

    companion object {
        private const val XINXILA_DISCORD_BOT_TOKEN = "XINXILA_DISCORD_BOT_TOKEN"

        suspend fun initialize() {
            val kord = Kord(System.getenv(XINXILA_DISCORD_BOT_TOKEN))

            kord.on<Event> {
                when (this) {
                    is MessageCreateEvent -> MessageCreateEventHandler().handle(this)
                }
            }

            kord.login {
                @OptIn(PrivilegedIntent::class)
                intents += Intent.MessageContent
            }
        }
    }
}