package com.savlanet.gratisshops.presentation

import android.content.res.Configuration
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.model.MediaStoreFileLoader
import com.bumptech.glide.signature.MediaStoreSignature
import com.savlanet.gratisshops.components.GratisCard
import com.savlanet.gratisshops.components.GratisSurface
import com.savlanet.gratisshops.components.offsetGradientBackground
import com.savlanet.gratisshops.ui.theme.*
import com.savlanet.gratisshops.utils.mirroringIcon
import com.savlanet.gratisshops.R
import com.savlanet.gratisshops.components.GratisVerificationIcon
import com.savlanet.gratisshops.model.*


private val HighlightCardWidth = 170.dp
private val HighlightCardPadding = 16.dp

// The Cards show a gradient which spans 3 cards and scrolls with parallax.
private val gradientWidth
    @Composable
    get() = with(LocalDensity.current) {
        (3 * (HighlightCardWidth + HighlightCardPadding).toPx())
    }


@Composable
fun ProductCollectionScreen(
    productCollection: ProductCollection,
    onProductClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    index: Int = 0,
    highlight: Boolean = true,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

   /* TopAppBar(
        title = {
            Text(
                text = "GratisShops",
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ) },
        backgroundColor = Color.White
    )*/

    Column(modifier = modifier) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(start = 24.dp)
        ) {
            Text(
                text = productCollection.name,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.primary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            IconButton(
                onClick = { /* todo */ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = mirroringIcon(
                        ltrIcon = Icons.Outlined.ArrowForward,
                        rtlIcon = Icons.Outlined.ArrowBack
                    ),
                    tint = MaterialTheme.colors.secondary,
                    contentDescription = null
                )
            }
        }
        if (highlight && productCollection.type == CollectionType.Highlight) {
            HighlightedProducts(index, productCollection.products, onProductClick)
        } else {
            Products(productCollection.products, onProductClick)
        }
    }
}

@Composable
private fun HighlightedProducts(
    index: Int,
    products: List<Product>,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val scroll = rememberScrollState(0)
    val gradient = when ((index / 2) % 2) {
        0 -> Cyan700
        else -> Purple500
    }
    // The Cards show a gradient which spans 3 cards and scrolls with parallax.
    val gradientWidth = with(LocalDensity.current) {
        (6 * (HighlightCardWidth + HighlightCardPadding).toPx())
    }
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp)
    ) {
        itemsIndexed(products) { index, product ->
            HighlightProductItem(
                product,
                onSnackClick,
                index,
                gradient,
                gradientWidth,
                scroll.value
            )
        }
    }
}

@Composable
private fun Products(
    products: List<Product>,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
    ) {
        items(products) { snack ->
            ProductItem(snack, onSnackClick)
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    onProductClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    GratisSurface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(
            start = 4.dp,
            end = 4.dp,
            bottom = 8.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable(onClick = { onProductClick(product.id) })
                .padding(8.dp)
        ) {
            ProductImage(
                imageUrl = product.imageUrl,
                elevation = 4.dp,
                contentDescription = null,
                modifier = Modifier.size(170.dp)
            )
            Text(
                text = product.name,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "from",
                style = MaterialTheme.typography.overline,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.vendorName,
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Row {
                VendorImage(
                    imageUrl = product.vendorImage,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                )
                if (product.verified) {
                    GratisVerificationIcon(
                        imageVector = Icons.Default.Verified,
                        contentDescription = "Verification Icon",
                        modifier = Modifier
                            .padding(top = 2.5.dp, start = 4.dp,)
                            .size(19.dp)
                    )
                } else {
                    Text("")
                }
            }
        }
    }
}

@Composable
private fun HighlightProductItem(
    product: Product,
    onProductClick: (Long) -> Unit,
    index: Int,
    gradient: Color,
    gradientWidth: Float,
    scroll: Int,
    modifier: Modifier = Modifier
) {
    val left = index * with(LocalDensity.current) {
        (HighlightCardWidth + HighlightCardPadding).toPx()
    }
    GratisCard(
        modifier = modifier
            .width(200.dp)
            .wrapContentHeight()
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = { onProductClick(product.id) })
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                val gradientOffset = left - (scroll / 3f)
                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                        .background(Cyan700)
                )
                ProductImage(
                    imageUrl = product.imageUrl,
                    contentDescription = "product",
                    modifier = Modifier
                        .size(170.dp)
                        .padding(top = 8.dp)
                        .align(Alignment.BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.tagLine,
                style = MaterialTheme.typography.overline,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.vendorName,
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Row() {
                VendorImage(
                    imageUrl = product.vendorImage,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp).clip(CircleShape)
                        .padding(start = 8.dp)
                        .border(width = 1.5.dp, color = Color.LightGray, shape = CircleShape)
                )
                if (product.verified) {
                    GratisVerificationIcon(
                        imageVector = Icons.Default.Verified,
                        contentDescription = "Verification Icon",
                        modifier = Modifier
                            .padding(start = 4.dp,)
                            .size(19.dp)
                    )
                }else{
                    Text("")
                }
            }
        }

    }
}

@Composable
fun ProductImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    GratisSurface (
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        val context = LocalContext.current

        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            placeholder = painterResource(R.drawable.wardrobe),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}


@Composable
fun VendorImage(
    @DrawableRes imageUrl: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    GratisSurface (
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {

        Image(
            painter = painterResource(id = imageUrl),
            contentDescription = contentDescription,
            modifier = Modifier
                .border(width = 1.5.dp, color = Color.LightGray, shape = CircleShape)
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

    }
}



/*
@OptIn(ExperimentalPagerApi::class)
@Composable
fun AdvertisementsPager(
    pagerState: PagerState,
    advertisements: List<Advertisement>,
    onAdvertiseClicked: (advertisement: Advertisement) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimension.pagePadding.div(2)),
    ) {
        /** Horizontal pager section */
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth(),
            count = advertisements.size,
            state = pagerState,
            itemSpacing = Dimension.pagePadding.times(2),
        ) {
            val advertisement = advertisements[this.currentPage]
            AsyncImage(
                model = advertisement.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f)
                    .clip(MaterialTheme.shapes.medium)
                    .clickable(
                        indication = null,
                        interactionSource = MutableInteractionSource(),
                        onClick = { onAdvertiseClicked(advertisement) }
                    ),
                contentScale = ContentScale.Crop,
            )
        }
        /** Horizontal pager indicators */
        LazyRow(
            contentPadding = PaddingValues(horizontal = Dimension.pagePadding.times(2)),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(pagerState.pageCount) { index ->
                Box(
                    modifier = Modifier
                        .width(
                            if (pagerState.currentPage == index) 8.dp.times(3)
                            else 8.dp
                        )
                        .height(8.dp)
                        .clip(CircleShape)
                        .background(
                            if (pagerState.currentPage == index) MaterialTheme.colors.primary
                            else MaterialTheme.colors.primary.copy(alpha = 0.4f)
                        )
                )
            }
        }
    }
}
*/

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun SnackCardPreview() {
    GratisShopsTheme {
        val product = products.first()
        HighlightProductItem(
            product = product,
            onProductClick = { },
            index = 0,
            gradient = Teal200,
            gradientWidth = gradientWidth,
            scroll = 0
        )
    }
}


/*   LaunchedEffect(key1 = Unit) {
        homeViewModel.getHomeAdvertisements()
    }

    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    val advertisementsUiState by remember { homeViewModel.homeAdvertisementsUiState }
    val advertisements = homeViewModel.advertisements

    val brandsUiState by remember { homeViewModel.brandsUiState }
    val brands = homeViewModel.brands

    val currentSelectedBrandIndex by remember { homeViewModel.currentSelectedBrandIndex }

    /** Now we configure the pager to auto scroll each 2 seconds, using Handler */
    val mainHandler = android.os.Handler(Looper.getMainLooper())
    val autoPagerScrollCallback = remember {
        object : Runnable {
            override fun run() {
                /** Handle where to scroll */
                val currentPage = pagerState.currentPage
                val pagesCount = pagerState.pageCount
                    Log.d("page","Current pager page is $currentPage and count is $pagesCount")
                when {
                    currentPage < (pagesCount - 1) -> {
                        /** go to next page */
                        scope.launch {
                            pagerState.animateScrollToPage(currentPage.inc())
                        }
                    }
                    else -> {
                        /** Start from beginning */
                        scope.launch {
                            pagerState.animateScrollToPage(0)
                        }
                    }
                }
                mainHandler.postDelayed(this, 3000)
            }
        }
    }*/

/** Staring our handler only once when the app is launched */
/*LaunchedEffect(key1 = Unit) {
    mainHandler.post(autoPagerScrollCallback)
}

   when (advertisementsUiState) {
        is UiState.Idle -> {}
        is UiState.Loading -> {
        }
        is UiState.Success -> {

            /** Advertisements section */

            AdvertisementsPager(
                pagerState = pagerState,
                advertisements = advertisements,
                onAdvertiseClicked = {}
            )
        }
        is UiState.Error -> {}
    }
*/