package bke.rtwp

import kotlin.math.floor

class Map {
    val tileWidth = 32f
    val tileHeight = 32f

    val tiles: Array<IntArray> = arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
            intArrayOf(1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    ).reversedArray()

    fun blocked(x: Int, y: Int) =
            !inBounds(x, y) || tiles[y][x] == 1

    fun getTilePos(x: Float, y: Float) =
            Pair(
                    floor(x / tileWidth).toInt(),
                    floor(y / tileHeight).toInt()
            )

    fun getScreenPos(tileX: Int, tileY: Int) =
            Pair(tileX * tileWidth, tileY * tileHeight)

    private fun inBounds(x: Int, y: Int) =
            (y >= 0 && y < tiles.size) && (x >= 0 && x < tiles[0].size)
}
