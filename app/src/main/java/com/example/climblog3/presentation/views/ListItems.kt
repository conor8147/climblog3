package com.example.climblog3.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.climblog3.R
import com.example.climblog3.presentation.ui.theme.ClimbLog3Theme
import com.example.climblog3.presentation.ui.theme.secondaryUltraLight

@Composable
fun ListHeaderItem(title: String, caption: String, onClick: () -> Unit) {
    val contentItemHeight = dimensionResource(R.dimen.list_heading_height)
    val horizontalPadding = dimensionResource(R.dimen.padding_m)

    Row(
        modifier = Modifier
            .height(contentItemHeight)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(start = horizontalPadding),
            style = MaterialTheme.typography.subtitle1,
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = caption,
                modifier = Modifier.padding(end = horizontalPadding),
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
    val contentItemHeight = dimensionResource(R.dimen.list_body_height)
    val leftIconPadding = dimensionResource(R.dimen.padding_xs)
    val verticalPadding = dimensionResource(R.dimen.padding_sm)
    val horizontalPadding = dimensionResource(R.dimen.padding_m)

    Surface(
        Modifier.height(contentItemHeight),
        color = MaterialTheme.colors.secondaryUltraLight.copy(alpha = 0.5f),
    ) {
        LeftIcon(Modifier.padding(start = leftIconPadding))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column {
                Text(
                    text = title,
                    modifier = Modifier.padding(horizontalPadding, top = verticalPadding),
                    style = MaterialTheme.typography.subtitle1,
                )

                Row {
                    Text(
                        text = caption,
                        modifier = Modifier.padding(start = horizontalPadding),
                        style = MaterialTheme.typography.caption,
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RightIcon(Modifier.padding(end = horizontalPadding))
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