package com.example.climblog3.presentation.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TallTopAppBar(title: String) {
    TopAppBar(
        modifier = Modifier.height(128.dp),
    ) {
        Row(
            Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.Top
        ) {
            ProvideTextStyle(value = typography.h6) {
                CompositionLocalProvider(
                    LocalContentAlpha provides ContentAlpha.high,
                    content = {
                        Text(
                            text = title,
                            style = typography.h6,
                            modifier = Modifier.padding(16.dp),
                        )
                    }
                )
            }
        }
    }
}