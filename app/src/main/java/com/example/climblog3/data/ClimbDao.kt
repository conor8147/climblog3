package com.example.climblog3.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ClimbDao {

    @Query("SELECT * from climb_table")
    fun getAll(): Flow<List<DbClimb>>

    @Insert(onConflict = IGNORE)
    suspend fun insertAll(vararg climb: DbClimb)

    @Delete
    suspend fun delete(climb: DbClimb)

    @Query("DELETE FROM climb_table")
    suspend fun clearDb()
}