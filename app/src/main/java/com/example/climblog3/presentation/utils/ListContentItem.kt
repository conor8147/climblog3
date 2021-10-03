package com.example.climblog3.presentation.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.climblog3.presentation.ui.theme.ClimbLog3Theme
import com.example.climblog3.presentation.ui.theme.secondaryUltraLight

@Composable
fun ListHeaderItem(title: String, caption: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.subtitle1,
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = caption,
                modifier = Modifier.padding(end = 16.dp),
                style = MaterialTheme.typography.caption,
            )
        }
    }
}

@Composable
fun ListContentItem(
    title: String,
    caption: String,
    LeftIcon: @Composable ((Modifier) -> Unit) = {},
    RightIcon: @Composable ((Modifier) -> Unit) = {},
) {
    Surface(
        Modifier.height(64.dp),
        color = MaterialTheme.colors.secondaryUltraLight,
    ) {
        LeftIcon(Modifier.padding(start = 4.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column {
                Text(
                    text = title,
                    modifier = Modifier.padding(start = 16.dp, top = 12.dp),
                    style = MaterialTheme.typography.subtitle1,
                )

                Row {
                    Text(
                        text = caption,
                        modifier = Modifier.padding(start = 16.dp),
                        style = MaterialTheme.typography.caption,
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RightIcon(Modifier.padding(end = 16.dp))
            }
        }
    }
}

@Composable
private fun StarsPreview(modifier: Modifier) {
    Text(
        text = "YEEE",
        style = MaterialTheme.typography.caption,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun Preview() {
    ClimbLog3Theme {
        Surface(color = MaterialTheme.colors.surface) {
            ListContentItem(
                title = "Lunge Starter",
                caption = "Wanaka",
                LeftIcon = { modifier ->
                    ColorAccent(color = MaterialTheme.colors.onError, modifier = modifier)
                },
                RightIcon = { modifier ->
                    StarsPreview(modifier)
                }
            )
        }
    }
}