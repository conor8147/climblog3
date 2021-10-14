package com.example.climblog3.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [DbClimb::class],
    version = DB_VERSION
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun climbDao(): ClimbDao
}

private const val DB_VERSION = 2