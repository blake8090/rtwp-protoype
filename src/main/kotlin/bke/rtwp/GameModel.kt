package bke.rtwp

import bke.rtwp.actor.Actor

class GameModel {
    val map = Map()
    val actors = mutableListOf<Actor>() // todo: extract to handle deletion
}
