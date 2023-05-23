package command

import dev.kord.core.entity.Message

class PingCommand : Command {

    companion object {
        private const val COMMAND = "!ping"
        private const val RESPONSE = "pong"
        val COMMAND_MAP = COMMAND to PingCommand()
    }

    override suspend fun execute(message: Message) {
        if (message.content == COMMAND) message.channel.createMessage(RESPONSE)
    }
}