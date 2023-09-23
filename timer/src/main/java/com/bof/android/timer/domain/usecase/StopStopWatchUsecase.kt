package com.bof.android.timer.domain.usecase

import com.bof.android.timer.domain.model.StopWatch
import javax.inject.Inject

/**
 * StopWatch Stop.
 */
class StopStopWatchUsecase @Inject constructor(private val stopWatch: StopWatch) {

    operator fun invoke() {
        stopWatch.stop()
    }
}