package com.savlanet.gratisshops.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.savlanet.gratisshops.R
import com.savlanet.gratisshops.components.GratisDivider
import com.savlanet.gratisshops.ui.theme.Poppins

@Composable
fun EditProfile() {

    val generalOptions = remember {
        listOf(Screen.Settings, Screen.OrderHistory)
    }
    val personalOptions = remember {
        listOf(Screen.PrivacyPolicies, Screen.TermsConditions)
    }

    TopAppBar(
        title = {
            Text(
                text = "Edit your profile",
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,

                )
        },
        backgroundColor = Color.White
    )

    Column(
        modifier = Modifier
            .padding(top = 18.dp, bottom = 10.dp, start = 4.dp, end = 4.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            modifier = Modifier
                .padding(5.dp)
                .padding(top = 30.dp, bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
                    .padding(12.dp),
                model = R.drawable.sayyadas_photo,
                contentDescription = null,
            )

            Text(text = "Change Profile Picture", color = MaterialTheme.colors.primary)

            Spacer(modifier = Modifier.height(16.dp))

            GratisDivider()

            Card(
                modifier = Modifier.clickable { }.wrapContentHeight(),
                shape = MaterialTheme.shapes.medium,
                backgroundColor = MaterialTheme.colors.secondary,

                ) {
                Column(
                    modifier = Modifier.padding(
                        top = 18.dp,
                        bottom = 10.dp,
                        start = 4.dp,
                        end = 4.dp
                    ),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "Add virtual card",
                            style = MaterialTheme.typography.button,
                        )
                        Icon(
                            Icons.Rounded.KeyboardArrowRight,
                            contentDescription = null
                        )

                    }
                    Text(
                        text = "Virtual cards allow you to purchase products.",
                        style = MaterialTheme.typography.body2,
                    )


                }
            }
           // LazyColumn() {
             //   item {
                    Text(
                        text = "General",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins,
                        modifier = Modifier.padding(top = 10.dp, bottom = 4.dp)
                    )
               // }

                generalOptions.forEach { option->
                    ProfileOptionItem(
                        icon = option.icon,
                        title = option.title,
                    ) {}

                    }
               /* items(generalOptions) { option ->
                    ProfileOptionItem(
                        icon = option.icon,
                        title = option.title,
                    ) {

                    }
                }*/

                Spacer(modifier = Modifier.height(10.dp))
                //item {
                    Text(
                        text = "Personal",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
               // }

                personalOptions.forEach {option->
                    ProfileOptionItem(
                        icon = option.icon,
                        title = option.title,
                        onOptionClicked = {},
                    )
                }
                /*items(personalOptions) { option ->
                    ProfileOptionItem(
                        icon = option.icon,
                        title = option.title,
                        onOptionClicked = {},
                    )
                }
            }*/

        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .padding(10.dp)
                .wrapContentSize(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 1.dp,
                disabledElevation = 0.dp
            ),
            shape = RoundedCornerShape(25)
        ) {
            Text(
                text = "Save",
                style = TextStyle(color = MaterialTheme.colors.primary),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }


        Text(
            text = "SignOut",
            modifier = Modifier
                .clickable { }
                .padding(top = 15.dp),
            color = Color.Red,
            fontSize = 17.sp
        )
    }
}

@Composable
fun ProfileOptionItem(icon: ImageVector?, title: String?, onOptionClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .clip(CircleShape)
            .fillMaxWidth()
            .clickable { onOptionClicked() },
        verticalAlignment = Alignment.CenterVertically,

    ) {
        DrawableButton(
            painter = icon,
            backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.4f),
            iconTint = MaterialTheme.colors.primary,
            onButtonClicked = {},
            iconSize = 30.dp,
            shape = CircleShape,
        )
        title?.let {
            Text(
                text = title,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.7f),
            )
        }

        Icon(
            Icons.Rounded.KeyboardArrowRight,
            contentDescription = null,
        )
    }
}

@Composable
private fun DrawableButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = MaterialTheme.colors.primary,
    iconTint: Color = Color.Unspecified,
    onButtonClicked: () -> Unit,
    painter: ImageVector?,
    shape: Shape = MaterialTheme.shapes.medium,
    iconSize: Dp = 30.dp,
    elevation: Dp = 0.dp,

) {
    Box(
        modifier = modifier
            .shadow(elevation = elevation, shape = shape)
            .clip(shape)
            .background(backgroundColor)
            .clickable(
                onClick = {
                    if (enabled) onButtonClicked()
                }
            )
            .padding(6.dp)
    ) {
        if (painter != null) {
            Icon(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(iconSize),
                imageVector = painter,
                contentDescription = "icon next",
                tint = iconTint,
            )
        }
    }
}

sealed class Screen(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null,
) {
    object Settings : Screen(
        route = "settings",
        title = "Settings",
        icon = Icons.Rounded.Settings,
    )

    object OrderHistory : Screen(
        route = "orders",
        title = "Transactions History",
        icon = Icons.Rounded.History,
    )

    object PrivacyPolicies : Screen(
        route = "privacy-policies",
        title = "Privacy",
        icon = Icons.Rounded.Lock,
    )

    object TermsConditions : Screen(
        route = "terms-conditions",
        title = "Terms and Conditions",
        icon = Icons.Rounded.Info,
    )
}
