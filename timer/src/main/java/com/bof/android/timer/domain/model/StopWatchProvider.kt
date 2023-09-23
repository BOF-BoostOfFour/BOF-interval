package com.bof.android.timer.domain.model

class StopWatchProvider {
    private var stopWatch: StopWatch? = null

    fun provide(elapsedTimeMs: Long = 0): StopWatch {
        return if (stopWatch == null) {
            StopWatch(elapsedTimeMs)
        } else {
            stopWatch!!
        }
    }

    fun destroy() {
        stopWatch?.reset()
        stopWatch = null
    }
}