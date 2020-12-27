package bke.rtwp.system

import bke.rtwp.Context
import bke.rtwp.actor.Actor
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class RenderSystem : System() {
    private lateinit var batch: SpriteBatch

    override fun init() {
        batch = SpriteBatch()
    }

    override fun update(context: Context, delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        drawMap(context)
        drawActors(context)
        batch.end()
    }

    private fun drawMap(context: Context) {
        val map = context.gameModel.map
        for ((y, column) in map.tiles.withIndex()) {
            for ((x, row) in column.withIndex()) {
                context.assets.getTile(row)?.let { texture ->
                    batch.draw(texture, (x * map.tileWidth), (y * map.tileHeight))
                }
            }
        }
    }

    private fun drawActors(context: Context) {
        for (actor in context.gameModel.actors) {
            drawActorDebug(context, actor)

            val texture = context.assets.getTexture(actor.textureName)
            if (texture != null) {
                batch.draw(texture, actor.spriteX, actor.spriteY)
            }
        }
    }

    private fun drawActorDebug(context: Context, actor: Actor) {
        val debugTexture = context.assets.getTexture("data/square.png")
        if (debugTexture != null) {
            batch.draw(
                    debugTexture,
                    actor.x * context.gameModel.map.tileWidth,
                    actor.y * context.gameModel.map.tileHeight
            )
        }
    }
}
