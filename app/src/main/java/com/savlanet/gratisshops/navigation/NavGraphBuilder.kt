package com.savlanet.gratisshops.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.savlanet.gratisshops.MainDestinations
import com.savlanet.pickstant.navigation.BottomNavSections

@Composable
fun GratisNavGraph(
    navController: NavHostController,
    onProductSelected: (Long, NavBackStackEntry) -> Unit,
    upPress: () -> Unit
){

    NavHost(
        navController = navController,
        startDestination = MainDestinations.SPLASH_ROUTE//BottomNavSections.HOME.screen_route

    ) {

        addSplashScreen(
            navController = navController,
            this
        )

        addHomeScreen(
            navController = navController,
            this,
            onProductSelected = onProductSelected
        )

        addVendorScreen(
            navController = navController,
            this,
            onProductSelected = onProductSelected
        )

        addSearchScreen(
            navController = navController,
            this,
            onProductSelected = onProductSelected
        )


        addCartScreen(
            navController = navController,
            this,
            onProductSelected = onProductSelected
        )

        addYouScreen(
            navController = navController,
            this,
        )


        addCheckoutScreen(
            navController = navController,
            this
        )

        addOnboardingScreen(
            navController = navController,
            this
        )

        addMapScreen(
            navController = navController,
            this
        )

        addEditProfileScreen(
            navController = navController,
            this
        )

        addProductDetailScreen(
            navController = navController,
            this,
            upPress = upPress
        )


    }
}

