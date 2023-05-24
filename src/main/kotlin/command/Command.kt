package command

import dev.kord.core.entity.Message

interface Command {

    val commandMap: Pair<String, Command>

    suspend fun execute(message: Message)
}