package com.bof.android.timer.domain.usecase

import com.bof.android.timer.domain.model.StopWatch
import javax.inject.Inject

/**
 * 현재 StopWatch 의 현재 시간을 가져옴.
 */
class GetCurTimeUsecase @Inject constructor(private val stopWatch: StopWatch) {

    operator fun invoke(): Long {
        return stopWatch.currentTimeMs
    }
}