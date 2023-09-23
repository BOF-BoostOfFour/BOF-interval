package com.bof.android.timer.domain.usecase

import com.bof.android.timer.domain.model.StopWatchProvider
import javax.inject.Inject

/**
 * StopWatch 생성.
 */
class CreateStopWatchUsecase @Inject constructor(private val stopWatchProvider: StopWatchProvider) {

    operator fun invoke(elapsedTimeMs: Long) {
        stopWatchProvider.provide(elapsedTimeMs)
    }
}