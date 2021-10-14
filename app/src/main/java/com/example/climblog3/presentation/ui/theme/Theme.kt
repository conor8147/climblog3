package com.example.climblog3.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

//private val DarkColorPalette = darkColors(
//    primary = Purple200,
//    primaryVariant = Purple700,
//    secondary = Teal200
//)

private val DarkColorPalette by lazy { LightColorPalette }

private val LightColorPalette = lightColors(
    primary = BlueGrey700,
    primaryVariant = BlueGrey900,
    secondary = Green300,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.Red,
)

val Colors.secondaryUltraLight: Color
    @Composable get() = if (isLight) Green50 else Green50

val Colors.dimmedBackground: Color
    @Composable get() = if (isLight) BlueGrey50 else BlueGrey50

@Composable
fun ClimbLog3Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
    ) {
        CompositionLocalProvider(
            LocalRippleTheme provides ClimbLog3RippleTheme,
            content = content,
        )
    }
}

private object ClimbLog3RippleTheme : RippleTheme {
    @Composable
    override fun defaultColor(): Color = MaterialTheme.colors.secondary

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        MaterialTheme.colors.onSurface,
        lightTheme = !isSystemInDarkTheme()
    )
}