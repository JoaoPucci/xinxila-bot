import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent

private const val XINXILA_DISCORD_BOT_TOKEN = "XINXILA_DISCORD_BOT_TOKEN"

suspend fun main() {

    val kord = Kord(System.getenv(XINXILA_DISCORD_BOT_TOKEN))

    // Simplified style
    kord.on<MessageCreateEvent> {
        if (message.author?.isBot == true) return@on
        if (message.content == "!ping") message.channel.createMessage("pong")
    }

    kord.login {
        @OptIn(PrivilegedIntent::class)
        intents += Intent.MessageContent
    }
}