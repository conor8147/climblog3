package com.example.climblog3.presentation.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.climblog3.presentation.ListContent
import com.example.climblog3.presentation.ListHeading

@ExperimentalAnimationApi
@Composable
fun NestedList(
    contents: Map<ListHeading, List<ListContent>>
) {
    val headings = contents.keys.toList()
    LazyColumn {
        items(headings) { heading ->
            var expanded by remember { mutableStateOf(false) }
            val content = contents[heading]
            ListHeaderItem(
                title = heading.title,
                caption = heading.caption,
                onClick = { expanded = !expanded },
            )
            Divider(modifier = Modifier.padding(start = 16.dp))
            ExpandableList(expanded, content)
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun ExpandableList(
    expanded: Boolean,
    content: List<ListContent>?,
) {
    AnimatedVisibility(
        visible = expanded,
        enter = expandVertically()
    ) {
        Column {
            content?.forEach { listContent ->
                ListContentItem(
                    title = listContent.title,
                    caption = listContent.caption,
                    LeftIcon = { modifier ->
                        listContent.LeftIcon(modifier)
                    },
                    RightIcon = { modifier ->
                        listContent.RightIcon(modifier)
                    }
                )
                Divider(modifier = Modifier.padding(start = 16.dp))
            }
        }
    }
}