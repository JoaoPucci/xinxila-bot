package discord.bot

import dev.kord.core.Kord
import dev.kord.core.event.Event
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import eventhandler.MessageCreateEventHandler

class DiscordBotImpl(
    private val kord: Kord,
    private val messageCreateEventHandler: MessageCreateEventHandler
) : DiscordBot {

    override suspend fun initialize() {
        setupEventListener()
        connect()
    }

    private suspend fun connect() {
        kord.login {
            @OptIn(PrivilegedIntent::class)
            intents += Intent.MessageContent
        }
    }

    private fun setupEventListener() {
        kord.on<Event> {
            when (this) {
                is MessageCreateEvent -> messageCreateEventHandler.handle(this)
            }
        }
    }
}