package bke.rtwp.event

import bke.rtwp.Context
import kotlin.reflect.KClass

abstract class Event

interface EventProcessor<T : Event> {
    fun process(context: Context, event: T)
}

class EventEngine(private val context: Context) {
    private val processors = mutableMapOf<KClass<out Event>, EventProcessor<out Event>>()

    fun <T : Event> add(clazz: KClass<T>, eventProcessor: EventProcessor<T>) {
        processors[clazz] = eventProcessor
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Event> fire(event: T) {
        val eventProcessor = processors[event::class]
        if (eventProcessor == null) {
            println("No event processor found for '${event::class.simpleName}'")
            return
        }
        (eventProcessor as EventProcessor<T>).process(context, event)
    }
}
