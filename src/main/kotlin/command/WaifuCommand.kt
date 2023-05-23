package command

import dev.kord.core.entity.Message

class WaifuCommand : Command {

    companion object {
        private const val COMMAND = "!waifu"
        private const val RESPONSE = "here your anime girl"
        val COMMAND_MAP = COMMAND to WaifuCommand()
    }

    override suspend fun execute(message: Message) {
        if (message.content == COMMAND) makeRequest(message)
    }

    private suspend fun makeRequest(message: Message) {
        message.channel.createMessage(RESPONSE)
    }
}