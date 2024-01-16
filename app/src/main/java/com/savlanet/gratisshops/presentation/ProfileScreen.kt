package com.savlanet.gratisshops.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Engineering
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.savlanet.gratisshops.MainDestinations
import com.savlanet.gratisshops.R
import com.savlanet.gratisshops.components.GratisDivider
import com.savlanet.gratisshops.ui.theme.*

@Composable
fun ProfileScreen(navController: NavController) {

    val scroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scroll)
            .padding(top = 8.dp, bottom = 55.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TopAppBar(
            title = {
                Text(
                    text = "Profile",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                ) },
            backgroundColor = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Kabir Ringim",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Kabeergarbahh@gmail.com",
            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 15.sp),
            color = Color.Gray,
            modifier = Modifier
                .padding(top = 6.dp)
        )
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(width = 1.5.dp, color = Color.LightGray, shape = CircleShape),
            model = R.drawable.sayyadas_photo,
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.5.dp,
                pressedElevation = 1.dp,
                disabledElevation = 0.dp),
            shape = RoundedCornerShape(30),
            modifier = Modifier.wrapContentSize()
        ) {
            Text(text = "Message", color = Purple700)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column {

            Producing(
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 10.dp, top = 14.dp)
            )


            Quantity(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 15.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))


            Divider()


            Text(
                text = "Welcome to my profile, let me guess, you probably saw one of my dynamic outfits, " +
                        "and now you are here, I hope you will look past the price and enjoy the unmatched " +
                        "exquisiteness. Feel free to leave me a message if you want to describe your own " +
                        "add-on components and features and I will make it custom made, " +
                        "for you.",
                modifier = Modifier.padding(top = 20.dp),
                textAlign = TextAlign.Center,
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Normal
                )
            )
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = { navController.navigate(MainDestinations.EDIT_PROFILE_ROUTE) },
                modifier = Modifier
                    .padding(10.dp, bottom = 15.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 2.dp,
                    disabledElevation = 0.dp
                ),
                shape = RoundedCornerShape(15)
            ) {
                Text(
                    text = "Edit Your Profile",
                    color = MaterialTheme.colors.primary
                )
            }
            GratisDivider(thickness = 2.dp)
            Spacer(modifier = Modifier.height(30.dp))

            Icon(
                imageVector = Icons.Filled.Engineering,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 40.dp)
                    .size(45.dp),
                tint = MaterialTheme.colors.primary
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = "This section is currently a work in progress ",
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "It will contain all a vendors products, their history, and any important details ",
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp)
            )

            Text(text = "", modifier = Modifier.padding(top = 15.dp, bottom = 20.dp))

    }
}
}

@Composable
private fun Producing(
    modifier: Modifier = Modifier,

) {

    Row {
        Text(
            text = "Sells -",
            color = Amber700,
            style = TextStyle(
                fontSize = 18.sp, fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .padding(start = 6.dp)
        )

        Text(
            text = "Handmade Apparels",
            modifier = Modifier
                .padding(start = 10.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif, fontWeight = FontWeight.Normal
            ),
        )

    }
}

@Composable
private fun Quantity(
    modifier: Modifier = Modifier,

    ) {

    Row {
        Text(
            text = "Qty Available -",
            color = Amber700,
            style = TextStyle(
                fontSize = 18.sp, fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .padding(start = 6.dp)
        )

        Text(
            text = "50",
            modifier = Modifier
                .padding(start = 10.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif, fontWeight = FontWeight.Normal
            ),
        )

    }
}

@Composable
fun BasicToolbar(title: String){
    TopAppBar(
        title = {Text(title)},
        backgroundColor = Color.White
    )
}