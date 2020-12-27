package bke.rtwp.system

import bke.rtwp.Context
import kotlin.math.max
import kotlin.math.min

class MovementSystem : System() {
    override fun update(context: Context, delta: Float) {
        for (actor in context.gameModel.actors) {
            if (actor.spriteTargetX != null) {
                actor.spriteX = moveTo(actor.spriteX, actor.spriteTargetX!!, actor.speed, delta)
                if (actor.spriteX == actor.spriteTargetX) {
                    actor.spriteTargetX = null
                }
            }

            if (actor.spriteTargetY != null) {
                actor.spriteY = moveTo(actor.spriteY, actor.spriteTargetY!!, actor.speed, delta)
                if (actor.spriteY == actor.spriteTargetY) {
                    actor.spriteTargetY = null
                }
            }
        }
    }

    private fun moveTo(start: Float, end: Float, speed: Float, delta: Float): Float {
        val dir =
                if (start < end) {
                    1
                } else {
                    -1
                }

        val result = start + (dir * speed * delta)

        return if (dir < 0) {
            max(result, end)
        } else {
            min(result, end)
        }
    }
}
