package com.bof.android.timer.domain.usecase

import com.bof.android.timer.domain.model.StopWatch
import javax.inject.Inject

/**
 * StopWatch Play.
 */
class PlayStopWatchUsecase @Inject constructor(private val stopWatch: StopWatch) {

    operator fun invoke(onTick: () -> Unit) {
        stopWatch.play(onTick)
    }
}