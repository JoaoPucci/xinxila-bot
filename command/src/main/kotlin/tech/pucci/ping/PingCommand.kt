package tech.pucci.ping

import dev.kord.core.entity.Message
import tech.pucci.Command

class PingCommand : Command {

    companion object {
        private const val COMMAND = "!ping"
        private const val RESPONSE = "pong"
    }

    override val commandMap: Pair<String, Command>
        get() = COMMAND to this

    override suspend fun execute(message: Message) {
        if (message.content == COMMAND) message.channel.createMessage(RESPONSE)
    }
}