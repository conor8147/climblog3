package com.example.climblog3.data

import com.example.climblog3.domain.Climb
import com.example.climblog3.domain.ClimbStyle
import kotlin.random.Random

val testClimbs: List<Climb> = (0..30).map { i ->
    val grade = Random.nextInt(16, 28)
        Climb(
            name = "Climb $i",
            crag = "Paine's",
            grade = grade.toString(),
            style = ClimbStyle.values().random()
        )
    }