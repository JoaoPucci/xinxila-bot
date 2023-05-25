package eventhandler

import dev.kord.core.event.Event

interface EventHandler<T: Event> {

    suspend fun handle(event: T)
}