package com.example.climblog3.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.climblog3.domain.Climb
import com.example.climblog3.domain.ClimbStyle

@Entity(tableName = "climb_table")
class DbClimb(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val grade: String,
    val style: String,
)

fun DbClimb.toModel(): Climb =
    Climb(
        id = id,
        name = name,
        grade = grade,
        style = ClimbStyle.valueOf(style),
    )

fun Climb.toDb(): DbClimb =
    DbClimb(
        id = id,
        name = name,
        grade = grade,
        style = style.name,
    )