package com.example.climblog3.di

import android.content.Context
import androidx.room.Room
import com.example.climblog3.data.AppDatabase
import com.example.climblog3.data.ClimbDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: AppDatabase): ClimbDao = database.climbDao()

}
