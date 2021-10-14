package com.example.climblog3.presentation.logbook

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.climblog3.R
import com.example.climblog3.presentation.MainApp
import com.example.climblog3.presentation.views.BottomSheet

@Composable
fun AddClimbBottomSheet(
    onDoneClicked: () -> Unit,
    nameTextState: MutableState<String>,
    cragTextState: MutableState<String>,
    gradeTextState: MutableState<String>,
    styleTextState: MutableState<String>,
    starsState: MutableState<Int>,
) {
    BottomSheet(
        Title = { modifier ->
            Title(modifier)
        },
        Content = { modifier ->
            Body(
                modifier = modifier,
                nameTextState = nameTextState,
                cragTextState = cragTextState,
                gradeTextState = gradeTextState,
                styleTextState = styleTextState,
                starsState = starsState,
            )
        },
        Button = { modifier ->
            DoneButton(modifier, onDoneClicked)
        }
    )
}

@Composable
private fun Title(modifier: Modifier) {
    Text(
        text = "Add Route",
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.Center,
        modifier = modifier,
    )
}

@Composable
private fun Body(
    modifier: Modifier,
    nameTextState: MutableState<String>,
    cragTextState: MutableState<String>,
    gradeTextState: MutableState<String>,
    styleTextState: MutableState<String>,
    starsState: MutableState<Int>,
) {
    val verticalPadding = dimensionResource(R.dimen.padding_ml)
    val horizontalPadding = dimensionResource(R.dimen.padding_ml)

    Column {
        StatefulTextField(
            label = "Name",
            modifier = modifier.padding(bottom = verticalPadding),
            textState = nameTextState,
        )
        StatefulTextField(
            label = "Crag",
            modifier = modifier.padding(bottom = verticalPadding),
            textState = cragTextState,
        )
        Row(
            modifier = modifier
                .padding(bottom = verticalPadding),
            horizontalArrangement = Arrangement.spacedBy(horizontalPadding)
        ){
            StatefulTextField(
                label = "Grade",
                modifier = Modifier
                    .weight(1f)
                ,
                textState = gradeTextState,
            )
            StatefulTextField(
                label = "Style",
                modifier = Modifier
                    .weight(1f),
                textState = styleTextState,
            )
        }
    }

}

@Composable
private fun StatefulTextField(
    label: String,
    modifier: Modifier,
    textState: MutableState<String>,
) {
    OutlinedTextField(
        value = textState.value,
        label = @Composable {
            Text(text = label)
        },
        onValueChange = {
            textState.value = it
        },
        shape = shapes.small,
        modifier = modifier,
    )
}

@Composable
private fun DoneButton(
    modifier: Modifier,
    onDoneClicked: () -> Unit,
) {
    Button(
        onClick = onDoneClicked,
        shape = shapes.small,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = MaterialTheme.colors.onSecondary,
        ),
        modifier = modifier
            .width(dimensionResource(R.dimen.button_width))
            .height(dimensionResource(R.dimen.button_height)),
    ) {
        Text("DONE")
    }
}

@Preview
@Composable
fun Preview() {
    val nameTextState = remember { mutableStateOf("") }
    val cragTextState = remember { mutableStateOf("") }
    val gradeTextState = remember { mutableStateOf("") }
    val styleTextState = remember { mutableStateOf("") }
    val starsState = remember { mutableStateOf(0) }

    MainApp {
        AddClimbBottomSheet(
            onDoneClicked = {},
            nameTextState = nameTextState,
            cragTextState = cragTextState,
            gradeTextState = gradeTextState,
            styleTextState = styleTextState,
            starsState = starsState,
        )
    }
}


