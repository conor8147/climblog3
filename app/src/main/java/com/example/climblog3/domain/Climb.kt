package com.example.climblog3.domain

data class Climb(
    val name: String,
    val crag: String,
    val grade: String,
    val style: ClimbStyle,
)

enum class ClimbStyle(private val asString: String) {
    ONSIGHT("Onsight"),
    FLASH("Flash"),
    SECOND_GO("Second go"),
    REDPOINT("Redpoint");

    override fun toString(): String = asString
}