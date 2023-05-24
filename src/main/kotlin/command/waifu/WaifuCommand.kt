package command.waifu

import command.Command
import command.waifu.repository.AnimeGirlHoldingProgrammingBooksRepository
import dev.kord.core.entity.Message

class WaifuCommand(private val repository: AnimeGirlHoldingProgrammingBooksRepository) : Command {

    companion object {
        private const val COMMAND = "!waifu"
    }

    override val commandMap: Pair<String, Command>
        get() = COMMAND to this

    override suspend fun execute(message: Message) {
        if (message.content == COMMAND) makeRequest(message)
    }

    private suspend fun makeRequest(message: Message) {
        repository.fetchKotlinGirl().collect {
            message.channel.createMessage(it)
        }
    }
}