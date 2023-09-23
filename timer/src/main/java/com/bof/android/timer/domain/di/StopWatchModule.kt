package com.bof.android.timer.domain.di

import com.bof.android.timer.domain.model.StopWatchProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StopWatchModule {

    @Provides
    @Singleton
    fun provideStopWatchProvider(): StopWatchProvider = StopWatchProvider()
}