package com.savlanet.gratisshops.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Cyan700,
    primaryVariant = Cyan700,
    secondary = Amber700,

)

private val LightColorPalette = lightColors(
    primary = Cyan700,
    primaryVariant = Cyan700,
    secondary = Amber700

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun GratisShopsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = UiBackground.copy(alpha = AlphaNearOpaque)
        )
    }


        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )



}

@Stable
class GratisColors(
    uiBackground: Color,
    uiFloated: Color,
    gradient2_1: List<Color>,
    gradient2_2: List<Color>,
    interactivePrimary: List<Color> = gradient2_1,
    interactiveSecondary: List<Color> = gradient2_2,

){
    var gradient2_1 by mutableStateOf(gradient2_1)
        private set
    var gradient2_2 by mutableStateOf(gradient2_2)
        private set
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var uiFloated by mutableStateOf(uiFloated)
        private set
    var interactivePrimary by mutableStateOf(interactivePrimary)
        private set
    var interactiveSecondary by mutableStateOf(interactiveSecondary)
        private set

    fun update(other: GratisColors) {
        gradient2_1 = other.gradient2_1
        gradient2_2 = other.gradient2_2
        uiBackground = other.uiBackground
        uiFloated = other.uiFloated
        interactivePrimary = other.interactivePrimary
        interactiveSecondary = other.interactiveSecondary
    }

    fun copy(): GratisColors = GratisColors(
        gradient2_1 = gradient2_1,
        gradient2_2 = gradient2_2,
        uiBackground = uiBackground,
        uiFloated = uiFloated,
        interactivePrimary = interactivePrimary,
        interactiveSecondary = interactiveSecondary,
    )
}

@Composable
fun ProvideGratisColors(
    colors: GratisColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalJetsnackColors provides colorPalette, content = content)
}

private val LocalJetsnackColors = staticCompositionLocalOf<GratisColors> {
    error("No JetsnackColorPalette provided")
}