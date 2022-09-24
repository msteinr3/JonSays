package com.example.jonsays.other

import android.content.Context

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLocalDataBase(@ApplicationContext appContext: Context): PageDatabase =
        PageDatabase.getDatabase(appContext)

    @Provides
    @Singleton
    fun providePageDao(database: PageDatabase) = database.PageDao()

}