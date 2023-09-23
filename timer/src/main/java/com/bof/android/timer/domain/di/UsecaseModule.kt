package com.bof.android.timer.domain.di

import com.bof.android.timer.domain.model.StopWatchProvider
import com.bof.android.timer.domain.usecase.GetCurTimeUsecase
import com.bof.android.timer.domain.usecase.PauseStopWatchUsecase
import com.bof.android.timer.domain.usecase.PlayStopWatchUsecase
import com.bof.android.timer.domain.usecase.StopStopWatchUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UsecaseModule {

    @Provides
    fun providesGetCurTimeUsecase(provider: StopWatchProvider): GetCurTimeUsecase = GetCurTimeUsecase(provider.provide())

    @Provides
    fun providesPauseStopWatchUsecase(provider: StopWatchProvider): PauseStopWatchUsecase = PauseStopWatchUsecase(provider.provide())

    @Provides
    fun providesPlayStopWatchUsecase(provider: StopWatchProvider): PlayStopWatchUsecase = PlayStopWatchUsecase(provider.provide())

    @Provides
    fun providesStopStopWatchUsecase(provider: StopWatchProvider): StopStopWatchUsecase = StopStopWatchUsecase(provider.provide())
}