package bke.rtwp

import bke.rtwp.event.EventEngine

class Context {
    val assets = Assets()
    val gameModel = GameModel()
    val eventEngine = EventEngine(this)
}
