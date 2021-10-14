package com.example.climblog3.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.climblog3.R

@Composable
fun ColorAccent(
    color: Color,
    modifier: Modifier,
) {
    val width = dimensionResource(R.dimen.color_accent_width)
    val padding = dimensionResource(R.dimen.padding_xxs)
    Box(
        modifier = modifier
            .width(width)
            .padding(top = padding, bottom = padding)
            .fillMaxHeight()
            .background(
                color = color,
                shape = MaterialTheme.shapes.small
            )
    )
}