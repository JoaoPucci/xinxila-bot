package tech.pucci.bot

import tech.pucci.discord.DiscordApi

class DiscordBotImpl(private val discord: DiscordApi) : DiscordBot {

    override suspend fun initialize() {
        discord.run {
            setupEventListener()
            connect()
        }
    }
}