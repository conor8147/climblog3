package com.example.climblog3.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.climblog3.presentation.ui.theme.ClimbLog3Theme

@Composable
fun MainApp(content: @Composable () -> Unit) {
    ClimbLog3Theme {
        Surface(color = MaterialTheme.colors.background) {
            content.invoke()
        }
    }
}