package com.savlanet.gratisshops.presentation.checkout

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.savlanet.gratisshops.model.Product
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.savlanet.gratisshops.MainDestinations
import com.savlanet.gratisshops.ui.theme.Poppins
import com.savlanet.gratisshops.R


object Dimension {
    val pagePadding = 24.dp
    val elevation = 4.dp
}


@Composable
fun CheckoutScreen(
  navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        /** Secondary top bar */
        TopAppBar(
            title = {
                Text(
                    text = "Checkout",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                ) },
            backgroundColor = Color.White
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState()),
        ) {

                    DeliveryLocationSection(
                        address = "House No5 Graphite Valley",
                        city = "Play Low Alto",
                        onChangeLocationRequested = {
//                          onChangeLocationRequested()
                        },
                    )

            /** Payment methods */
            PaymentMethodsSection(
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .shadow(
                        elevation = com.savlanet.gratisshops.presentation.checkout.Dimension.elevation.div(2),
                        shape = RoundedCornerShape(
                            topStartPercent = 15,
                            topEndPercent = 15,
                        ),
                        spotColor = MaterialTheme.colors.primary,
                    )
                    .clip(shape = MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colors.background)
                    .padding(all = com.savlanet.gratisshops.presentation.checkout.Dimension.pagePadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                /** sub total cost row */
                SummaryRow(
                    title = stringResource(id = R.string.sub_total),
                    value = "50,000 Naira"
                )
                /** shipping cost row */
                SummaryRow(
                    title = stringResource(id = R.string.shipping),
                    value = "1500 Naira"
                )
                Divider()
                /** total cost row */
                SummaryRow(
                    title = stringResource(id = R.string.total),
                    value = "51,500 Naira"
                )
                Button(
                    modifier = Modifier
                        .padding(top = Dimension.pagePadding)
                        .fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    onClick = { navController.navigate(MainDestinations.MAP_ROUTE) }
                ){
                    Text(text = "Pay Now")
                }
            }
        }
    }
}

@Composable
fun DeliveryLocationSection(
    address: String,
    city: String,
    onChangeLocationRequested: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(Dimension.pagePadding),
        verticalArrangement = Arrangement.spacedBy(Dimension.pagePadding),
    ) {
        Text(
            text = "Delivery Address",
            style = MaterialTheme.typography.button,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Dimension.pagePadding),
        ) {
           Icon(
               imageVector = Icons.Default.MyLocation,
               contentDescription = null,
               modifier = Modifier.size(28.dp),
               tint = MaterialTheme.colors.primary
           )
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = address,
                    style = MaterialTheme.typography.h6,
                )
                Text(
                    text = city,
                    style = MaterialTheme.typography.body1,
                )
            }
            Icon(
                Icons.Default.ArrowForward,
                contentDescription = null
            )
        }
    }
}

fun String.encryptCardNumber(): String {
    return "**** ".repeat(3).plus(this.takeLast(4))
}

@Composable
fun FirstPm() {

    Column(
        modifier = Modifier.padding(Dimension.pagePadding),
        verticalArrangement = Arrangement.spacedBy(Dimension.pagePadding),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Dimension.pagePadding),
        ) {
            DrawableButton(
                paddingValue = PaddingValues(8.dp),
                elevation = 4.dp,
                painter = painterResource(id = R.drawable.ic_master_card),
                onButtonClicked = { },
                backgroundColor = MaterialTheme.colors.background,
                shape = MaterialTheme.shapes.medium,
                iconSize = 40.dp,
            )
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = "Master Card",
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    text = "**** **** **** 6293",
                    style = MaterialTheme.typography.caption,
                )
            }
            RadioButton(
                selected = false,
                onClick = {  },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colors.secondary,
                    unselectedColor = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                )
            )
        }
    }

}

@Composable
fun SecondPm() {

    Column(
        modifier = Modifier.padding(Dimension.pagePadding),
        verticalArrangement = Arrangement.spacedBy(Dimension.pagePadding),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Dimension.pagePadding),
        ) {
            DrawableButton(
                paddingValue = PaddingValues(8.dp),
                elevation = 4.dp,
                painter = painterResource(id = R.drawable.ic_visa),
                onButtonClicked = { },
                backgroundColor = MaterialTheme.colors.background,
                shape = MaterialTheme.shapes.medium,
                iconSize = 40.dp,
            )
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = "Visa",
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    text = "**** **** **** 2198",
                    style = MaterialTheme.typography.caption,
                )
            }
            RadioButton(
                selected = false,
                onClick = {  },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colors.secondary,
                    unselectedColor = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                )
            )
        }
    }

}


@Composable
fun ThirdPm() {

    Column(
        modifier = Modifier.padding(Dimension.pagePadding),
        verticalArrangement = Arrangement.spacedBy(Dimension.pagePadding),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Dimension.pagePadding),
        ) {
            DrawableButton(
                paddingValue = PaddingValues(8.dp),
                elevation = 4.dp,
                painter = painterResource(id = R.drawable.ic_apple),
                onButtonClicked = { },
                backgroundColor = MaterialTheme.colors.background,
                shape = MaterialTheme.shapes.medium,
                iconSize = 38.dp,
            )
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = "Apple Pay",
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    text = "**** **** **** 7262",
                    style = MaterialTheme.typography.caption,
                )
            }
            RadioButton(
                selected = false,
                onClick = {  },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colors.secondary,
                    unselectedColor = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                )
            )
        }
    }

}


@Composable
fun PaymentMethodsSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(Dimension.pagePadding),
        verticalArrangement = Arrangement.spacedBy(Dimension.pagePadding),
    ) {
        Text(
            text = "Payment Methods",
            fontSize = 24.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

            Column(

            ) {
                FirstPm()

                SecondPm()

                ThirdPm()
        }
    }
}



@Composable
fun SummaryRow(
    title: String,
    value: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.SemiBold),
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
        )

        Text(
            text = value,
            style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.SemiBold),
            color = MaterialTheme.colors.secondary,
        )
    }
}



@Composable
fun DrawableButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = MaterialTheme.colors.primary,
    iconTint: Color = Color.Unspecified,
    onButtonClicked: () -> Unit,
    painter: Painter,
    shape: Shape = MaterialTheme.shapes.medium,
    iconSize: Dp = 16.dp,
    elevation: Dp = 0.dp,
    paddingValue: PaddingValues = PaddingValues(4.dp),
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
            .padding(paddingValues = paddingValue)
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.Center)
                .size(iconSize),
            painter = painter,
            contentDescription = "icon next",
            tint = iconTint,
        )
    }
}

