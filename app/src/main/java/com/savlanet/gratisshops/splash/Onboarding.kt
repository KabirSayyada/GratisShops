package com.savlanet.gratisshops.splash

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.savlanet.gratisshops.MainDestinations
import com.savlanet.gratisshops.ui.theme.*

@Composable
fun OnboardingScreen(
    navController: NavController
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "GratisShops",
            fontFamily = FontFamily.Cursive,
            fontSize = 40.sp,
            color = Cyan700,
            modifier = Modifier.padding(top = 60.dp)
        )

        Spacer(modifier = Modifier.height(250.dp))

        Text(
            text = "No matter how picky you are, there is always something for you here",
            fontFamily = Karla,
            fontSize = 28.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )

        Text(
            text = "find products made for you, from vendors that are here just for you",
            fontWeight = FontWeight.Normal,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = Cyan700,
            modifier = Modifier.padding(top = 15.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "let's show you around",
            fontWeight = FontWeight.Normal,
            color = Color.Gray,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Button(
            onClick = {
                navController.navigate(MainDestinations.HOME_ROUTE) {
                    popUpTo(MainDestinations.ONBOARDING_ROUTE) {
                        inclusive = true
                    }
                }
                      },
            colors = ButtonDefaults.buttonColors(backgroundColor = Amber700),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.5.dp,
                pressedElevation = 1.dp,
                disabledElevation = 0.dp),
            shape = RoundedCornerShape(30),
            modifier = Modifier.wrapContentSize()
        ) {
            Text(text = "Sign In as Guest", fontSize = 20.sp)
        }
    }
}
