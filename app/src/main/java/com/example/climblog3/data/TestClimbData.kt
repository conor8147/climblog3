package com.example.climblog3.data

import com.example.climblog3.domain.Climb
import com.example.climblog3.domain.ClimbStyle
import kotlin.random.Random

val testClimbs: List<Climb> = (0..100).map { i ->
    val grade = Random.nextInt(16, 28)
        Climb(
            id = i,
            name = "Climb $i",
            grade = grade.toString(),
            style = ClimbStyle.values().random()
        )
    }