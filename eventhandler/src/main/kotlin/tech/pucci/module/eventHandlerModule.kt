package tech.pucci.module

import org.koin.dsl.module
import tech.pucci.MessageCreateEventHandler

val eventHandlerModule = module {
    factory { MessageCreateEventHandler(pingCommand = get(), waifuCommand = get()) }
}