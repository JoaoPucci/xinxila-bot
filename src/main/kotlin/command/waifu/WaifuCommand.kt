package command.waifu

import command.Command
import command.waifu.repository.AnimeGirlHoldingProgrammingBooksRepository
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.entity.Message
import io.ktor.client.request.forms.ChannelProvider

class WaifuCommand(private val repository: AnimeGirlHoldingProgrammingBooksRepository) : Command {

    companion object {
        private const val COMMAND = "!waifu"
        private const val FILE_NAME = "waifu"
    }

    override val commandMap: Pair<String, Command>
        get() = COMMAND to this

    override suspend fun execute(message: Message) {
        if (message.content == COMMAND) makeRequest(message)
    }

    private suspend fun makeRequest(message: Message) {
        repository.fetchRandomWaifu().collect {
            val contentProvider = ChannelProvider {
                it.second
            }

            message.channel.createMessage {
                addFile(FILE_NAME + it.first, contentProvider)
            }
        }
    }
}