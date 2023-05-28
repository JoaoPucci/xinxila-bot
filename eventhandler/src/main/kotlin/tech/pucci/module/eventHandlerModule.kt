package tech.pucci.module

import tech.pucci.MessageCreateEventHandler
import org.koin.dsl.module

val eventHandlerModule = module {
    factory { MessageCreateEventHandler(pingCommand = get(), waifuCommand = get()) }
}