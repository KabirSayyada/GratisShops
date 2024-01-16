package com.savlanet.gratisshops.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.savlanet.gratisshops.MainDestinations
import com.savlanet.gratisshops.model.Vendor
import com.savlanet.gratisshops.presentation.EditProfile
import com.savlanet.gratisshops.presentation.Product
import com.savlanet.gratisshops.presentation.ProfileScreen
import com.savlanet.gratisshops.presentation.VendorsList
import com.savlanet.gratisshops.presentation.cart.Cart
import com.savlanet.gratisshops.presentation.cart.CartScreen
import com.savlanet.gratisshops.presentation.checkout.CheckoutScreen
import com.savlanet.gratisshops.presentation.map.GratisMapScreen
import com.savlanet.gratisshops.presentation.search.Search
import com.savlanet.gratisshops.presentation.snackdetail.ProductDetail
import com.savlanet.gratisshops.splash.OnboardingScreen
import com.savlanet.gratisshops.splash.SplashScreen
import com.savlanet.pickstant.navigation.BottomNavSections

fun addSplashScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,

    ){
    navGraphBuilder.composable(MainDestinations.SPLASH_ROUTE) {

        SplashScreen(
            onSplashFinished = {
                navController.navigate(MainDestinations.ONBOARDING_ROUTE) {
                    popUpTo(MainDestinations.SPLASH_ROUTE) {
                        inclusive = true
                    }
                }
            }
        )
    }
}


fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    onProductSelected: (Long, NavBackStackEntry) -> Unit,
    modifier: Modifier = Modifier

){
    navGraphBuilder.composable(BottomNavSections.HOME.screen_route) { from ->
        Product(onProductClick = { id -> onProductSelected(id, from) }, modifier)
    }
}


fun addVendorScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    onProductSelected: (Long, NavBackStackEntry) -> Unit,
    modifier: Modifier = Modifier

){
    //val vendor = listOf<Vendor>()
    navGraphBuilder.composable(BottomNavSections.Vendors.screen_route) {
        VendorsList()
    }
}

fun addSearchScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    onProductSelected: (Long, NavBackStackEntry) -> Unit,
    modifier: Modifier = Modifier

){
    navGraphBuilder.composable(BottomNavSections.Search.screen_route) { from ->
        Search(onProductClick = { id -> onProductSelected(id, from) }, modifier)
    }
}


fun addCartScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    onProductSelected: (Long, NavBackStackEntry) -> Unit,
    modifier: Modifier = Modifier

){
    navGraphBuilder.composable(BottomNavSections.Cart.screen_route) { from ->
        CartScreen(onProductClick = { id -> onProductSelected(id, from) }, modifier, navController = navController)
    }
}


fun addYouScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,

    ){
    navGraphBuilder.composable(BottomNavSections.YOU.screen_route) {
        ProfileScreen(navController)
    }
}


fun addEditProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,

    ){
    navGraphBuilder.composable(MainDestinations.EDIT_PROFILE_ROUTE) {
        EditProfile()
    }
}

fun addOnboardingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,

    ){
    navGraphBuilder.composable(MainDestinations.ONBOARDING_ROUTE) {
        OnboardingScreen(navController)
    }
}

fun addCheckoutScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,

    ){
    navGraphBuilder.composable(MainDestinations.CHECKOUT_ROUTE) {
        CheckoutScreen(navController)
    }
}

fun addMapScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,

    ){
    navGraphBuilder.composable(MainDestinations.MAP_ROUTE) {
        GratisMapScreen()
    }
}

fun addProductDetailScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    upPress: () -> Unit
){
    navGraphBuilder.composable(
        "${MainDestinations.PRODUCT_DETAIL_ROUTE}/{${MainDestinations.PRODUCT_ID_KEY}}",
        arguments = listOf(navArgument(MainDestinations.PRODUCT_ID_KEY) { type = NavType.LongType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val productId = arguments.getLong(MainDestinations.PRODUCT_ID_KEY)
        ProductDetail(productId, upPress)
    }
}