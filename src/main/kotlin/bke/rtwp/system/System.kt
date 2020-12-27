package bke.rtwp.system

import bke.rtwp.Context

abstract class System {
    open fun init() {}
    abstract fun update(context: Context, delta: Float)
}
