package com.example.climblog3.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.climblog3.domain.Climb
import com.example.climblog3.domain.ClimbStyle
import kotlinx.coroutines.flow.Flow

@Composable
fun LogbookScreenContent(viewModel: LogbookViewModel = viewModel()) {
    val grades by viewModel.allGrades.collectAsState(emptyList())

    LozengeList(grades, viewModel::getClimbsForGrade)
}

@Composable
private fun ClimbHeader() {
    Text(
        text = "Climb:",
        fontSize = 36.sp,
        modifier = Modifier.padding(4.dp),
    )
}

@Composable
private fun LozengeList(
    headings: List<String>,
    getContentByHeading: (String) -> Flow<List<Climb>>,
    onItemSelected: (String) -> Unit = {},
) {
    Column(
        Modifier.fillMaxSize()
    ) {
        ClimbHeader()

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(headings) { heading ->
                val content by getContentByHeading(heading).collectAsState(emptyList())

                LozengeListItem(heading, content, onItemSelected)
            }
        }
    }
}

@Composable
private fun LozengeListItem(mainText: String, content: List<Climb>, onClick: (String) -> Unit) {
    var isSelected by remember { mutableStateOf(true) }

    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                isSelected = !isSelected
                onClick(mainText)
            },
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = mainText,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
            )

            if (isSelected) {
                LozengeItemBody(content)
            }
        }
    }
}

@Composable
private fun LozengeItemBody(content: List<Climb>) {
    Divider(
        color = Color.Black,
        modifier = Modifier.height(0.5.dp)
    )
    Column {
        content.forEach { item ->
            Text(
                text = item.name,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Preview
@Composable
private fun LogbookScreenPreview() {
    val climbs = listOf(
        Climb(
            id = 0,
            name = "The Butcher",
            grade = "24",
            style = ClimbStyle.REDPOINT
        ),
        Climb(
            id = 0,
            name = "Flash Pump",
            grade = "26",
            style = ClimbStyle.REDPOINT
        ),
    )
    Surface(modifier = Modifier.fillMaxSize()) {
//        LozengeList(climbs.map { it.grade }.distinct(), )
    }
}