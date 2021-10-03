package com.example.climblog3.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.climblog3.domain.Climb
import com.example.climblog3.domain.ClimbStyle
import com.example.climblog3.presentation.ui.theme.ClimbLog3Theme
import com.example.climblog3.presentation.ui.theme.dimmedBackground
import com.example.climblog3.presentation.views.ColorAccent
import com.example.climblog3.presentation.views.FAB
import com.example.climblog3.presentation.views.NestedList
import com.example.climblog3.presentation.views.TallTopAppBar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Composable
fun LogbookScreen(viewModel: LogbookViewModel = viewModel()) {
    val climbsByGrade by viewModel
        .climbsByGrade
        .toListModel()
        .collectAsState(emptyMap())

    LogbookScreenContent(climbsByGrade, viewModel::addClimb)
}

@Composable
private fun LogbookScreenContent(
    climbsByGrade: Map<ListHeading, List<ListContent>>,
    onAddClimb: () -> Unit
) {
    Surface(
        color = colors.dimmedBackground
    ) {
        TallTopAppBar(title = "Logbook")
        OverlayContainer {
            NestedList(climbsByGrade)
        }
    }
    FAB(onClick = onAddClimb)
}

@Composable
private fun OverlayContainer(content: @Composable () -> Unit) {
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
            .background(color = colors.surface)
    ) {
        content.invoke()
    }
}

private fun Flow<Map<String, List<Climb>>>.toListModel(): Flow<Map<ListHeading, List<ListContent>>> =
    map {
        it.entries.associate { (grade, climbs) ->
            grade.toListHeading(climbs.size) to climbs.toListContent()
        }
    }

private fun String.toListHeading(climbCount: Int) = object : ListHeading {
    override val id: String = this@toListHeading
    override val title: String = "Grade: ${this@toListHeading}"
    override val caption: String = "Total: $climbCount"
}

private fun List<Climb>.toListContent() = map { climb ->

    object : ListContent {
        override val title: String = climb.name
        override val caption: String = climb.grade // TODO make this crag
        override val LeftIcon: @Composable (Modifier) -> Unit = { modifier ->
            ColorAccent(
                color = getColorFor(climb.style),
                modifier = modifier
            )
        }
        override val RightIcon: @Composable (Modifier) -> Unit = { modifier ->

        }
        override val parentId: String = climb.grade
    }
}

@Composable
private fun getColorFor(style: ClimbStyle): Color {
    return colors.error
}

@Preview
@Composable
private fun LogbookScreenPreview() {
    ClimbLog3Theme {
        Surface(
            color = colors.dimmedBackground
        ) {
            LogbookScreenContent(emptyMap()) {}
        }
    }
}