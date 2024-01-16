package com.savlanet.gratisshops

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.savlanet.gratisshops.components.GratisScaffold
import com.savlanet.gratisshops.components.GratisSnackbar
import com.savlanet.gratisshops.navigation.GratisNavGraph
import com.savlanet.gratisshops.presentation.snackdetail.ProductDetail
import com.savlanet.gratisshops.ui.theme.GratisShopsTheme
import com.savlanet.pickstant.navigation.BottomNavSections
import com.savlanet.pickstant.navigation.GratisBottomBar
import com.savlanet.pickstant.navigation.JetsnackBottomBar


@Composable
fun GratisApp() {
    GratisShopsTheme {
        val appState = rememberGratisAppState()
        //val navController = rememberNavController()
        val tabs = remember { BottomNavSections.values() }

        Scaffold(
            snackbarHost = {
                SnackbarHost(
                    hostState = it,
                    modifier = Modifier.padding(8.dp),
                    snackbar = { snackBarData ->
                        Snackbar(snackBarData, contentColor = MaterialTheme.colors.onPrimary)
                    }
                )
            },

            bottomBar = {
                if (appState.shouldShowBottomBar){
                    JetsnackBottomBar(
                        tabs = appState.bottomBarTabs,
                        currentRoute = appState.currentRoute.toString(),
                        navigateToRoute = appState::navigateToBottomBarRoute
                    )
                }
            /*    if (appState.shouldShowBottomBar) {
                    GratisBottomBar(
                        navController = navController,
                        tabs = appState.bottomBarTabs,
                        //currentRoute = appState.currentRoute!!,
                        //navigateToRoute = appState::navigateToBottomBarRoute
                    )
                }*/
            },

            scaffoldState = appState.scaffoldState,
        ) { innerPaddingModifier ->

            GratisNavGraph(
                navController = appState.navController,
                onProductSelected = appState::navigateToProductDetail,
                upPress = appState::upPress
            )
        }
    }
}


/*private fun NavGraphBuilder.GratisNavGraph(
    onProuctSelected: (Long, NavBackStackEntry) -> Unit,
    upPress: () -> Unit
) {
    navigation(
        route = MainDestinations.HOME_ROUTE,
        startDestination = MainDestinations.SPLASH_ROUTE
    ) {
        addHomeGraph(onProuctSelected)
    }
    composable(
        "${MainDestinations.PRODUCT_DETAIL_ROUTE}/{${MainDestinations.PRODUCT_ID_KEY}}",
        arguments = listOf(navArgument(MainDestinations.PRODUCT_ID_KEY) { type = NavType.LongType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val productId = arguments.getLong(MainDestinations.PRODUCT_ID_KEY)
        ProductDetail(productId, upPress)
    }
}

 */