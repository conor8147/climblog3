package com.example.climblog3.data

import com.example.climblog3.domain.Climb
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface LocalDataSource {
    fun getAll(): Flow<List<Climb>>

    suspend fun write(climb: Climb)

    suspend fun delete(climb: Climb)

    suspend fun clearDb()
}

class LocalDataSourceImpl @Inject constructor(
    private val climbDao: ClimbDao
) : LocalDataSource {

    override fun getAll(): Flow<List<Climb>> = climbDao.getAll().map { climbList ->
        climbList.map { climb -> climb.toModel() }
    }

    override suspend fun write(climb: Climb) {
        climbDao.insertAll(climb.toDb())
    }

    override suspend fun delete(climb: Climb) {
        climbDao.delete(climb.toDb())
    }

    override suspend fun clearDb() {
        climbDao.clearDb()
    }
}