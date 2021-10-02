package com.example.climblog3.data

import com.example.climblog3.domain.Climb
import com.example.climblog3.domain.ClimbStyle
import kotlin.random.Random

val testClimbs: List<Climb> = (0..50).map { i ->
    val grade = Random.nextInt(10, 39)
        Climb(
            id = i,
            name = "Climb $i",
            grade = grade.toString(),
            style = ClimbStyle.values().random()
        )
    }