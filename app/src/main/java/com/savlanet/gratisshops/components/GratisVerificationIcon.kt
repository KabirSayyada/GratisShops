package com.savlanet.gratisshops.components

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.savlanet.gratisshops.ui.theme.GratisShopsTheme

@Composable
fun GratisVerificationIcon(
    imageVector: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier,

    ){
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier,
        tint =  MaterialTheme.colors.primary
    )
}