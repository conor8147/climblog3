package com.example.climblog3.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorAccent(
    color: Color,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .width(2.dp)
            .padding(top = 4.dp, bottom = 4.dp)
            .fillMaxHeight()
            .background(
                color = color,
                shape = MaterialTheme.shapes.small
            )
    )
}