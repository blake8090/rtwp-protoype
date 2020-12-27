package bke.rtwp.util

data class Point(
    var x: Float = 0f,
    var y: Float = 0f
) {
    operator fun plus(point: Point) {
        x += point.x
        y += point.y
    }
}
