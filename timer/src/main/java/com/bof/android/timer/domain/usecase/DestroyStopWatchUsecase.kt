package com.bof.android.timer.domain.usecase

import com.bof.android.timer.domain.model.StopWatchProvider
import javax.inject.Inject

/**
 * StopWatch 파괴.
 */
class DestroyStopWatchUsecase @Inject constructor(private val stopWatchProvider: StopWatchProvider) {

    operator fun invoke(elapsedTimeMs: Long) {
        stopWatchProvider.destroy()
    }
}