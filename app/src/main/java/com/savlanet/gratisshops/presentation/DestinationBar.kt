package com.savlanet.gratisshops.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.savlanet.gratisshops.components.GratisDivider
import com.savlanet.gratisshops.ui.theme.AlphaNearOpaque
import com.savlanet.gratisshops.ui.theme.GratisShopsTheme
import com.savlanet.gratisshops.ui.theme.UiBackground

@Composable
fun DestinationBar(modifier: Modifier = Modifier) {
    Column(modifier = modifier.statusBarsPadding()) {
        TopAppBar(
            backgroundColor = UiBackground.copy(alpha = AlphaNearOpaque),
            contentColor = MaterialTheme.colors.secondary,
            elevation = 0.dp
        ) {
            Text(
                text = "Delivery to Houses Realview Way",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.secondary,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            IconButton(
                onClick = { /* todo */ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ExpandMore,
                    tint = MaterialTheme.colors.primary,
                    contentDescription = null
                )
            }
        }
        GratisDivider()
    }
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun PreviewDestinationBar() {
    GratisShopsTheme {
        DestinationBar()
    }
}
