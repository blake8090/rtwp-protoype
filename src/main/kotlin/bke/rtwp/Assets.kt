package bke.rtwp

import com.badlogic.gdx.graphics.Texture

class Assets {
    private val tileSet = mutableMapOf<Int, Texture>()
    private val texturesByFileName = mutableMapOf<String, Texture>()

    fun loadTile(fileName: String, id: Int) {
        tileSet[id] = Texture(fileName)
    }

    fun getTile(id: Int): Texture? {
        return tileSet[id]
    }

    fun loadTexture(fileName: String) {
        texturesByFileName[fileName] = Texture(fileName)
    }

    fun getTexture(fileName: String): Texture? {
        return texturesByFileName[fileName]
    }

    fun dispose() {
        tileSet.values.forEach(Texture::dispose)
        texturesByFileName.values.forEach(Texture::dispose)
    }
}
