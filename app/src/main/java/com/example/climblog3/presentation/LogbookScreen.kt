package com.example.climblog3.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.climblog3.presentation.ui.theme.ClimbLog3Theme
import com.example.climblog3.presentation.ui.theme.dimmedBackground

@Composable
fun LogbookScreenContent(viewModel: LogbookViewModel = viewModel()) {
    val grades by viewModel.allGrades.collectAsState(emptyList())
    Surface(
        color = MaterialTheme.colors.dimmedBackground
    ) {
        TallTopAppBar(title = "Logbook")
        OverlayContainer {
            NestedList()
        }
    }
}

@Composable
fun OverlayContainer(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 72.dp,
                start = 30.dp,
                end = 30.dp,
                bottom = 30.dp,
            )
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colors.surface)
    ) {
        content.invoke()
    }
}

@Preview()
@Composable
private fun LogbookScreenPreview() {
    ClimbLog3Theme {
        Surface(
            color = MaterialTheme.colors.dimmedBackground
        ) {
            OverlayContainer {

            }
        }
    }
}
