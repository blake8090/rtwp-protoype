package bke.rtwp.system

import bke.rtwp.Context

abstract class System {
    abstract fun init()
    abstract fun update(context: Context, delta: Float)
}
