package com.example.climblog3.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*

@Composable
fun NestedList(
    headings: List<ListHeading>,
    contents: Map<Int, List<ListContent>>
) {
    var expanded by remember { mutableStateOf(false) }
    LazyColumn {
        items(headings) { heading ->
            val content = contents[heading.id]
            Column {
                ListHeaderItem(
                    title = heading.title,
                    caption = heading.caption,
                    onClick = { expanded = !expanded },
                )
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
    }
}