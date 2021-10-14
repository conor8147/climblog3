package com.example.climblog3.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.climblog3.R

@Composable
fun BottomSheet(
    Title: @Composable (Modifier) -> Unit,
    Content: @Composable (Modifier) -> Unit,
    Button: @Composable (Modifier) -> Unit,
) {
    val headerPadding = dimensionResource(id = R.dimen.padding_l)
    val verticalPadding = dimensionResource(id = R.dimen.padding_l)
    val horizontalPadding = dimensionResource(id = R.dimen.padding_l)

    Surface(
        color = Color.Black.copy(alpha = 0.45f),
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.large)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = MaterialTheme.colors.surface)

            ) {
                Title(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = headerPadding)
                )
                Content(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalPadding)
                )
                Button(
                    Modifier
                        .padding(start = horizontalPadding)
                        .padding(vertical = verticalPadding)
                )

            }
        }
    }

}
