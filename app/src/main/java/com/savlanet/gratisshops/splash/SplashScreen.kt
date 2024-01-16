package com.savlanet.gratisshops.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.savlanet.gratisshops.presentation.Screen
import com.savlanet.gratisshops.ui.theme.Teal200
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.savlanet.gratisshops.MainDestinations
import com.savlanet.gratisshops.R
import com.savlanet.gratisshops.ui.theme.Cyan700
import kotlinx.coroutines.delay

private const val SPLASH_WAIT_TIME = 5000L


@Composable
fun SplashScreen(
    splashViewModel: SplashViewModel = hiltViewModel(),
    onSplashFinished: () -> Unit,

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cyan700),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        val currentOnTimeOut by rememberUpdatedState(onSplashFinished)


        LaunchedEffect(key1 = Unit) {
            delay(SPLASH_WAIT_TIME)
            currentOnTimeOut()
        }
        val appName = stringResource(id = R.string.app_name)
        Text(
            /** Manipulate app's name with a different text styles */
            text = buildAnnotatedString {
                append(appName.take(11))
                withStyle(
                    style = MaterialTheme.typography.h1
                        .copy(
                            fontSize = 64.sp,
                            color = Color.Black,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.Bold
                        ).toSpanStyle(),
                ){
                    //append(appName.slice(..10))
                }
            //    append(appName.takeLast(1))
            },
            style = MaterialTheme.typography.h1
                .copy(
                    fontSize = 64.sp,
                    color = MaterialTheme.colors.secondary,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                ),
        )
    }
}