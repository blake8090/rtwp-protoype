package bke.rtwp.system

import bke.rtwp.Context
import bke.rtwp.actor.Player
import bke.rtwp.event.MoveEvent
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input

class InputSystem : System() {
    override fun update(context: Context, delta: Float) {
        val player = context.gameModel.actors.filterIsInstance<Player>()
                .firstOrNull()
                ?: return

        var dx = 0
        var dy = 0

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            dy = 1
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            dy = -1
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            dx = -1
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            dx = 1
        }

        if (dx != 0 || dy != 0) {
            context.eventEngine.fire(MoveEvent(player, dx, dy))
        }
    }
}
