

package com.savlanet.gratisshops.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.savlanet.gratisshops.ui.theme.GratisShopsTheme
import com.savlanet.gratisshops.ui.theme.Neutral4

@Composable
fun GratisDivider(
    modifier: Modifier = Modifier,
    color: Color = Neutral4.copy(alpha = DividerAlpha),
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
) {
    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness,
        startIndent = startIndent
    )
}

private const val DividerAlpha = 0.12f

@Preview("default", showBackground = true)
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun DividerPreview() {
    GratisShopsTheme {
        Box(Modifier.size(height = 10.dp, width = 100.dp)) {
            GratisDivider(Modifier.align(Alignment.Center))
        }
    }
}
