package discord

class GetBotAuthTokenUseCaseImpl : GetBotAuthTokenUseCase {

    companion object {
        private const val XINXILA_DISCORD_BOT_TOKEN = "XINXILA_DISCORD_BOT_TOKEN"
    }

    override val token: String
        get() = System.getenv(XINXILA_DISCORD_BOT_TOKEN)
}