package bke.rtwp

import bke.rtwp.actor.Player
import bke.rtwp.event.MoveEvent
import bke.rtwp.event.MoveEventProcessor
import bke.rtwp.system.InputSystem
import bke.rtwp.system.MovementSystem
import bke.rtwp.system.RenderSystem
import bke.rtwp.system.System
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx

class Game : ApplicationAdapter() {
    private val context = Context()
    private val systems = LinkedHashSet<System>()

    override fun create() {
        context.eventEngine.add(MoveEvent::class, MoveEventProcessor())

        systems.add(InputSystem())
        systems.add(MovementSystem())
        systems.add(RenderSystem())
        systems.forEach(System::init)

        with(context.assets) {
            loadTile("data/floor.png", 0)
            loadTile("data/wall.png", 1)
            loadTexture("data/circle.png")
            loadTexture("data/enemy.png")
            loadTexture("data/box.png")
            loadTexture("data/square.png")
        }

        context.gameModel.actors.add(
                Player().apply {
                    textureName = "data/circle.png"
                    speed = 200f
                }
        )
    }

    override fun render() {
        for (system in systems) {
            system.update(context, Gdx.graphics.deltaTime)
        }
    }

    override fun dispose() {
        context.assets.dispose()
    }
}
