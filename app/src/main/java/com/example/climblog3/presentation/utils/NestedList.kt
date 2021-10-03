package com.example.climblog3.presentation.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import com.example.climblog3.presentation.ListContent
import com.example.climblog3.presentation.ListHeading

@Composable
fun NestedList(
    contents: Map<ListHeading, List<ListContent>>
) {
    val headings = contents.keys.toList()
    LazyColumn {
        items(headings) { heading ->
            var expanded by remember { mutableStateOf(false) }
            val content = contents[heading]
            Column {
                ListHeaderItem(
                    title = heading.title,
                    caption = heading.caption,
                    onClick = { expanded = !expanded },
                )
                ExpandableList(expanded, content)
            }
        }
    }
}

@Composable
private fun ExpandableList(
    expanded: Boolean,
    content: List<ListContent>?,
) {
    if (expanded) {
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
        }
    }
}