package tech.pucci.discord

interface DiscordApi {

    suspend fun setupEventListener()
    suspend fun connect()
}