package bke.rtwp.system

import bke.rtwp.Context

class ActionSystem : System() {
    override fun update(context: Context, delta: Float) {
        for (actor in context.gameModel.actors) {
            val action = actor.action ?: continue

            if (!action.fired) {
                println("firing off action!")
                context.eventEngine.fire(action.event)
                action.fired = true
            }

            action.elapsedTime += delta

            if (action.elapsedTime >= action.durationSeconds) {
                actor.action = null
                println("action expired!")
            }
        }
    }
}
