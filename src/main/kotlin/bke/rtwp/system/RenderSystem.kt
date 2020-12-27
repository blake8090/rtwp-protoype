package bke.rtwp.system

import bke.rtwp.Context
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
}
