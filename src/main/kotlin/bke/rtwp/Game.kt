package bke.rtwp

import bke.rtwp.system.RenderSystem
import bke.rtwp.system.System
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx

class Game : ApplicationAdapter() {
    private val context = Context()
    private val systems = LinkedHashSet<System>()

    override fun create() {
        systems.add(RenderSystem())
        systems.forEach(System::init)

        with(context.assets) {
            loadTile("data/floor.png", 0)
            loadTile("data/wall.png", 1)
            loadTexture("data/circle.png")
            loadTexture("data/enemy.png")
            loadTexture("data/box.png")
        }
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
