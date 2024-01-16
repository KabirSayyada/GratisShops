package com.savlanet.gratisshops.presentation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.savlanet.gratisshops.components.FilterBar
import com.savlanet.gratisshops.components.GratisDivider
import com.savlanet.gratisshops.components.GratisSurface
import com.savlanet.gratisshops.model.Filter
import com.savlanet.gratisshops.model.ProductCollection
import com.savlanet.gratisshops.model.ProductRepo

@Composable
fun Product(
    onProductClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val productCollections = remember { ProductRepo.getProducts() }
    val filters = remember { ProductRepo.getFilters() }
    Home(
        productCollections,
        filters,
        onProductClick,
        modifier
    )
}

@Composable
private fun Home(
    productCollections: List<ProductCollection>,
    filters: List<Filter>,
    onProductClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {

    GratisSurface(modifier = modifier.fillMaxSize().padding(bottom = 50.dp)) {
        Box {
            ProductCollectionList(productCollections, filters, onProductClick)
            DestinationBar()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun ProductCollectionList(
    productCollections: List<ProductCollection>,
    filters: List<Filter>,
    onProductClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    var filtersVisible by rememberSaveable { mutableStateOf(false) }
    Box(modifier) {
        LazyColumn {

            item {
                Spacer(
                    Modifier.windowInsetsTopHeight(
                        WindowInsets.statusBars.add(WindowInsets(top = 56.dp))
                    )
                )
                FilterBar(filters, onShowFilters = { filtersVisible = true })
            }
            itemsIndexed(productCollections) { index,productCollection ->
                if (index > 0) {
                    GratisDivider(thickness = 3.dp)
                }

                ProductCollectionScreen(
                    productCollection = productCollection,
                    onProductClick = onProductClick,
                    index = index
                )
            }
        }
    }

    AnimatedVisibility(
        visible = filtersVisible,
        enter = slideInVertically() + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ) {
        FilterScreen(
            onDismiss = { filtersVisible = false }
        )
    }
}
