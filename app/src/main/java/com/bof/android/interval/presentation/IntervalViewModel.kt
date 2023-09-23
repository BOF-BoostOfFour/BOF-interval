package com.bof.android.interval.presentation

import androidx.lifecycle.ViewModel
import com.bof.android.timer.domain.usecase.CreateStopWatchUsecase
import com.bof.android.timer.domain.usecase.GetCurTimeUsecase
import com.bof.android.timer.domain.usecase.PlayStopWatchUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntervalViewModel @Inject constructor(
    private val createStopWatchUsecase: CreateStopWatchUsecase,
    private val playStopWatchUsecase: PlayStopWatchUsecase,
    private val getCurTimeUsecase: GetCurTimeUsecase
) : ViewModel() {

    fun createStopWatch(elapsedTimeMs: Long) {
        createStopWatchUsecase(elapsedTimeMs)
    }

    fun playStopWatch(onTick: () -> Unit) {
        playStopWatchUsecase(onTick)
    }

    fun getCurTime(): Long = getCurTimeUsecase()
}