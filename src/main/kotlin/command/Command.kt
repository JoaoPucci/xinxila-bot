package command

import dev.kord.core.entity.Message

interface Command {
    suspend fun execute(message: Message)
}