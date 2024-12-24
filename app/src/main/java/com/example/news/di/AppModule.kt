package com.example.news.di

import android.app.Application
import com.example.news.data.manger.LocalUserMangerImpl
import com.example.news.domain.manger.LocalUserManger
import com.example.news.domain.usecases.AppEntryUseCases
import com.example.news.domain.usecases.ReadAppEntry
import com.example.news.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEnteryUseCases(
        localUserManger: LocalUserManger
    ) = AppEntryUseCases(

        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
}

