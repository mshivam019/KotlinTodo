
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlintodo.composeapp.generated.resources.Res
import kotlintodo.composeapp.generated.resources.compose_multiplatform

val lightRedColor = Color(color = 0xFFF57D88)
val darkRedColor = Color(color = 0xFFF7700B)

@Composable
@Preview
fun App() {
    val lightColors = lightColorScheme(
        primary= lightRedColor,
        onPrimary = darkRedColor,
        primaryContainer = lightRedColor,
        onPrimaryContainer = darkRedColor
    )
    val darkColors = darkColorScheme(
        primary = lightRedColor,
        onPrimary = darkRedColor,
        primaryContainer = lightRedColor,
        onPrimaryContainer = darkRedColor
    )
    val colors by mutableStateOf(
        if(isSystemInDarkTheme()) darkColors else lightColors
    )
    MaterialTheme(colorScheme =  colors) {


    }
}