package com.bof.android.timer.domain.model

import java.util.Timer
import java.util.TimerTask

/**
 * StopWatch: java util Timer 이용, 스탑 워치의 전체 로직을 담당.
 * @param elapsedTimeMs: 시작 할 초기화 시간(생성자 매개 변수).
 */
class StopWatch(private val elapsedTimeMs: Long): BOFTimer {
    //----------------------------------------------------------
    // Definition value.
    companion object {
        // 10 밀리 초가 하나의 틱.
        private const val INTERVAL_TIME_MS = 10L
    }

    //----------------------------------------------------------
    // instance variable.
    private val timer: Timer = Timer()
    // 현재 시각.

    override var currentTimeMs: Long = elapsedTimeMs

    //----------------------------------------------------------
    // public interface.
    /**
     * 재생.
     * @param onTick: play 할 때, 한 번의 Tick 할 때 콜백.
     */
    override fun play(onTick: () -> Unit) {
        // 타이머 동작 정의.
        val timerTask = object: TimerTask() {
            override fun run() {
                // 현재 시간 - 한 번의 틱 시간.
                currentTimeMs -= INTERVAL_TIME_MS
                // 한 번, 틱하고 콜백 실행.
                onTick()
            }
        }
        // 타이머 시작.
        timer.scheduleAtFixedRate(timerTask, 0, INTERVAL_TIME_MS)
    }

    /**
     * 일시 정지.
     */
    override fun pause() {
        timer.cancel()
    }

    /**
     * 정지
     */
    override fun stop() {
        currentTimeMs = 0L
        timer.cancel()
    }

    /**
     * 앞으로 감기
     */
    override fun fastForward() {
        currentTimeMs = 0L
        timer.cancel()
    }

    /**
     * 뒤로 감기
     */
    override fun rewind() {
        currentTimeMs = elapsedTimeMs
        timer.cancel()
    }

    /**
     * reset
     */
    override fun reset() {
        stop()
        currentTimeMs = elapsedTimeMs
    }

    //----------------------------------------------------------
    // private sub method
    /**
     * todo test result for debug
     */
    private fun formatTime(milliseconds: Long): String {
        val totalSeconds = milliseconds / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        val fraction = (milliseconds % 1000) / 10  // 100분의 1초 단위

        return String.format("%02d분 %02d.%02d초", minutes, seconds, fraction)
    }
}