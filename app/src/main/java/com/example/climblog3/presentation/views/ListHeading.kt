package com.example.climblog3.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface ListHeading {
    val id: String
    val title: String
    val caption: String
}

interface ListContent {
    val title: String
    val caption: String
    val LeftIcon: @Composable (Modifier) -> Unit
    val RightIcon: @Composable (Modifier) -> Unit
    val parentId: String
}