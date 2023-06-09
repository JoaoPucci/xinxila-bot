package tech.pucci

import dev.kord.core.event.message.MessageCreateEvent
import tech.pucci.ping.PingCommand
import tech.pucci.waifu.WaifuCommand

class MessageCreateEventHandler(
    pingCommand: PingCommand,
    waifuCommand: WaifuCommand
) : EventHandler<MessageCreateEvent> {

    companion object {
        private const val EXCLAMATION_MARK = "!"
    }

    private val commands: Map<String, Command> = mapOf(
        pingCommand.commandMap,
        waifuCommand.commandMap
    )

    override suspend fun handle(event: MessageCreateEvent) {
        if (event.message.author?.isBot == true) return

        event.message.content.run {
            if (startsWith(EXCLAMATION_MARK)) {
                val command = commands[this]
                command?.execute(event.message)
            }
        }
    }
}