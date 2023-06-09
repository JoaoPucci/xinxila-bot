package tech.pucci.waifu

import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.entity.Message
import io.ktor.client.request.forms.ChannelProvider
import tech.pucci.Command
import tech.pucci.exception.NetworkErrorException
import tech.pucci.waifu.network.repository.AnimeGirlsWithBooksRepository

class WaifuCommand(private val repository: AnimeGirlsWithBooksRepository) : Command {

    companion object {
        private const val COMMAND = "!waifu"
        private const val FILE_NAME = "waifu."
    }

    override val commandMap: Pair<String, Command>
        get() = COMMAND to this

    override suspend fun execute(message: Message) {
        if (message.content == COMMAND) makeRequest(message)
    }

    private suspend fun makeRequest(message: Message) {
        repository.fetchRandomWaifu().collect { result ->
            result.onSuccess {
                val contentProvider = ChannelProvider { it.image }

                message.channel.createMessage {
                    addFile(FILE_NAME + it.fileExtension, contentProvider)
                }
            }.onFailure {
                val error = it as NetworkErrorException
                message.channel.createMessage(error.errorImageUrl)
            }
        }
    }
}