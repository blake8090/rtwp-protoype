package bke.rtwp.event

import bke.rtwp.Context
import bke.rtwp.actor.Actor

data class MoveEvent(
        val target: Actor,
        val dx: Int,
        val dy: Int
) : Event()

class MoveEventProcessor : EventProcessor<MoveEvent> {
    override fun process(context: Context, event: MoveEvent) {
        val map = context.gameModel.map
        val actor = event.target

        if (actor.action != null) {
            return
        }

        val tileX = actor.x + event.dx
        val tileY = actor.y + event.dy

        if (!map.blocked(tileX, actor.y) && actor.spriteTargetX == null) {
            actor.x = tileX
            actor.spriteTargetX = tileX * map.tileWidth
        }

        if (!map.blocked(actor.x, tileY) && actor.spriteTargetY == null) {
            actor.y = tileY
            actor.spriteTargetY = tileY * map.tileHeight
        }
    }
}
