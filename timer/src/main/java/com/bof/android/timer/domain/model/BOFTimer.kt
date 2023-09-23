package com.bof.android.timer.domain.model

/**
 * StopWatch or 일반 Timer 같은 Timer가 가질 Interface.
 */
interface BOFTimer {
    var currentTimeMs: Long

    /**
     * 재생
     */
    fun play(onTick: () -> Unit)

    /**
     * 일시 정지
     */
    fun pause()

    /**
     * 정지
     */
    fun stop()

    /**
     * 앞으로 감기.
     */
    fun fastForward()

    /**
     * 뒤로 감기.
     */
    fun rewind()

    /**
     * 리셋.
     */
    fun reset()
}