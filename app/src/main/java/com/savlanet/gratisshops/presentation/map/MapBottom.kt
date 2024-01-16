package com.savlanet.gratisshops.presentation.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.savlanet.gratisshops.components.GratisCard
import com.savlanet.gratisshops.components.GratisDivider
import com.savlanet.gratisshops.ui.theme.Cyan700

@Composable
fun MapsBottom(){
    GratisCard(modifier = Modifier.background(MaterialTheme.colors.primary)) {
    Column() {
        Text(
            text = "A rider has been notifird, rider is 5 minutes away from your location",
        )
        GratisDivider()
            Row {
                Text(
                    text = "riders info",
                    color = Cyan700
                )

                Icon(
                    imageVector = Icons.Default.DirectionsBike,
                    contentDescription = null,
                    tint = MaterialTheme.colors.secondary,
                    modifier = Modifier.size(30.dp)
                )
            }
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "name: The Flash",
        )

        Text(
            text = "mobile: +234 80 2222 3333"
        )

        }
    }
}