package bke.rtwp.event

import bke.rtwp.Context

class AttackEvent : Event()

class AttackEventProcessor : EventProcessor<AttackEvent> {
    override fun process(context: Context, event: AttackEvent) {
        println("Attacking nothing in particular.")
    }
}
