package com.example.climblog3.data

import androidx.annotation.WorkerThread
import com.example.climblog3.domain.Climb
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface AppRepository {
    val allClimbs: Flow<List<Climb>>

    @WorkerThread
    suspend fun insert(climb: Climb)

    @WorkerThread
    suspend fun delete(climb: Climb)

    suspend fun clear()
}


class AppRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : AppRepository {
    override val allClimbs: Flow<List<Climb>> = localDataSource.getAll()

    @WorkerThread
    override suspend fun insert(climb: Climb) {
        localDataSource.write(climb)
    }

    @WorkerThread
    override suspend fun delete(climb: Climb) {
        localDataSource.delete(climb)
    }

    override suspend fun clear() {
        localDataSource.clearDb()
    }
}