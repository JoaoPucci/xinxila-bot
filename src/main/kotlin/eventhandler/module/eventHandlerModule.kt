package eventhandler.module

import eventhandler.MessageCreateEventHandler
import org.koin.dsl.module

val eventHandlerModule = module {
    factory { MessageCreateEventHandler(pingCommand = get(), waifuCommand = get()) }
}