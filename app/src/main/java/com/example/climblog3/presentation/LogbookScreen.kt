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
import com.example.climblog3.presentation.ui.theme.ClimbLog3Theme
import com.example.climblog3.presentation.ui.theme.dimmedBackground
import com.example.climblog3.presentation.utils.ColorAccent
import com.example.climblog3.presentation.utils.NestedList
import com.example.climblog3.presentation.utils.TallTopAppBar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Composable
fun LogbookScreenContent(viewModel: LogbookViewModel = viewModel()) {
    val climbsByGrade by viewModel.climbsByGrade.collectAsState(emptyMap())

    val content = climbsByGrade.toListModel()

    Surface(
        color = colors.dimmedBackground
    ) {
        TallTopAppBar(title = "Logbook")
        OverlayContainer {
            NestedList(
                content
            )
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
            .background(color = colors.surface)
    ) {
        content.invoke()
    }
}

@Preview
@Composable
private fun LogbookScreenPreview() {
    ClimbLog3Theme {
        Surface(
            color = colors.dimmedBackground
        ) {
            OverlayContainer {

            }
        }
    }
}

@Composable
private fun Map<String, List<Climb>>.toListModel(): Map<ListHeading, List<ListContent>> =
    entries.associate { (grade, climbs) ->
        grade.toListHeading(climbs.size) to climbs.toListContent()
    }

@Composable
fun String.toListHeading(climbCount: Int) = object : ListHeading {
    override val id: String = this@toListHeading
    override val title: String = "Grade: ${this@toListHeading}"
    override val caption: String = "Total: $climbCount"
}

@Composable
private fun List<Climb>.toListContent() = map { climb ->
    val styleColor = getColorFor(climb)

    object : ListContent {
        override val title: String = climb.name
        override val caption: String = climb.grade // TODO make this crag
        override val LeftIcon: @Composable (Modifier) -> Unit = { modifier ->
            ColorAccent(
                color = styleColor,
                modifier = modifier
            )
        }
        override val RightIcon: @Composable (Modifier) -> Unit = { modifier ->

        }
        override val parentId: String = climb.grade
    }
}

@Composable
private fun getColorFor(climb: Climb): Color {
    return colors.error
}