package com.example.climblog3.di

import com.example.climblog3.data.AppRepository
import com.example.climblog3.data.AppRepositoryImpl
import com.example.climblog3.data.LocalDataSource
import com.example.climblog3.data.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindLocalDataSource(localDataSource: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindRepository(appRepository: AppRepositoryImpl): AppRepository

}