package bke.rtwp.actor

import bke.rtwp.event.Event

data class Action(
        val event: Event,
        val durationSeconds: Float
) {
    var elapsedTime = 0f
    var fired = false
}
