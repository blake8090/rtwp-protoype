package bke.rtwp.actor

open class Actor {
    var x: Int = 0
    var y: Int = 0

    var spriteX: Float = 0f
    var spriteY: Float = 0f
    var spriteTargetX: Float? = null
    var spriteTargetY: Float? = null

    var textureName = ""

    var speed: Float = 0f

    var action: Action? = null
}

class Player : Actor()
