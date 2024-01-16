package com.savlanet.gratisshops.presentation.snackdetail

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.Verified
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.*
import com.savlanet.gratisshops.R
import com.savlanet.gratisshops.components.*
import com.savlanet.gratisshops.model.Product
import com.savlanet.gratisshops.model.ProductCollection
import com.savlanet.gratisshops.model.ProductRepo
import com.savlanet.gratisshops.presentation.ProductCollectionScreen
import com.savlanet.gratisshops.presentation.ProductImage
import com.savlanet.gratisshops.presentation.VendorImage
import com.savlanet.gratisshops.presentation.map.SmalllerMap
import com.savlanet.gratisshops.ui.theme.*
import com.savlanet.gratisshops.utils.mirroringBackIcon
import kotlin.math.max
import kotlin.math.min


private val BottomBarHeight = 56.dp
private val TitleHeight = 128.dp
private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 56.dp
private val MinImageOffset = 12.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll
private val ExpandedImageSize = 300.dp
private val CollapsedImageSize = 150.dp
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun ProductDetail(
    snackId: Long,
    upPress: () -> Unit
) {
    val snack = remember(snackId) { ProductRepo.getProduct(snackId) }
    val related = remember(snackId) { ProductRepo.getRelated(snackId) }

    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header()
        Body(related, scroll)
        Title(snack) { scroll.value }
        Image(snack.imageUrl) { scroll.value }
        Up(upPress)
        CartBottomBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .background(Brush.horizontalGradient(listOf(Cyan700, Amber700)))
    )
}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = Color.LightGray.copy(alpha = 0.32f),
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = mirroringBackIcon(),
            tint = Purple700,
            contentDescription = "Back"
        )
    }
}

@Composable
private fun Body(
    related: List<ProductCollection>,
    scroll: ScrollState
) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier.verticalScroll(scroll).padding(top = 37.dp)
        ) {
            Spacer(Modifier.height(GradientScroll))
            GratisSurface(Modifier.fillMaxWidth()) {
                Column {
                    Spacer(Modifier.height(ImageOverlap))
                    Spacer(Modifier.height(TitleHeight))

                    Spacer(Modifier.height(16.dp).padding(top = 25.dp))
                    Text(
                        text = "Product Details",
                        style = MaterialTheme.typography.overline,
                        color = Color.Gray,
                        modifier = HzPadding
                    )
                    Spacer(Modifier.height(16.dp))
                    var seeMore by remember { mutableStateOf(true) }
                    Text(
                        text = stringResource(R.string.detail_placeholder),
                        style = MaterialTheme.typography.body1,
                        color = Color.Gray,
                        maxLines = if (seeMore) 5 else Int.MAX_VALUE,
                        overflow = TextOverflow.Ellipsis,
                        modifier = HzPadding
                    )
                    val textButton = if (seeMore) {
                        stringResource(id = R.string.see_more)
                    } else {
                        stringResource(id = R.string.see_less)
                    }
                    Text(
                        text = textButton,
                        style = MaterialTheme.typography.button,
                        textAlign = TextAlign.Center,
                        color = Purple500,
                        modifier = Modifier
                            .heightIn(20.dp)
                            .fillMaxWidth()
                            .padding(top = 15.dp)
                            .clickable {
                                seeMore = !seeMore
                            }
                    )
                    Spacer(Modifier.height(40.dp))
                    Text(
                        text = stringResource(R.string.ingredients),
                        style = MaterialTheme.typography.overline,
                        color = Color.Gray,
                        modifier = HzPadding
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.ingredients_list),
                        style = MaterialTheme.typography.body1,
                        color = Color.DarkGray,
                        modifier = HzPadding
                    )

                    Spacer(Modifier.height(16.dp))
                    GratisDivider()

                    related.forEach { snackCollection ->
                        key(snackCollection.id) {
                            ProductCollectionScreen(
                                productCollection = snackCollection,
                                onProductClick = { },
                                highlight = false
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier
                            .padding(bottom = BottomBarHeight)
                            .navigationBarsPadding()
                            .height(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Title(snack: Product, scrollProvider: () -> Int) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .offset {
                val scroll = scrollProvider()
                val offset = (maxOffset - scroll).coerceAtLeast(minOffset)
                IntOffset(x = 0, y = offset.toInt())
            }
            .background(color = UiBackground)
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = snack.name,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary,
            modifier = HzPadding
        )
        Text(
            text = snack.tagLine,
            style = MaterialTheme.typography.subtitle2,
            fontSize = 20.sp,
            color = Color.Gray,
            modifier = HzPadding
        )
        Text(
            text = snack.vendorName,
            style = MaterialTheme.typography.h6,
            color = Amber700,
            modifier = HzPadding
        )

        Row {
            VendorImage(
                imageUrl = snack.vendorImage,
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .padding(start = 24.dp)
            )
            if (snack.verified) {
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

        Spacer(Modifier.height(4.dp))
        Text(
            text = "${snack.price} Naira",
            style = MaterialTheme.typography.h6,
            color = Cyan700,
            modifier = HzPadding
        )

        Spacer(Modifier.height(8.dp))
        GratisDivider()
    }
}

@Composable
private fun Image(
    imageUrl: String,
    scrollProvider: () -> Int
) {
    val collapseRange = with(LocalDensity.current) { (MaxTitleOffset - MinTitleOffset).toPx() }
    val collapseFractionProvider = {
        (scrollProvider() / collapseRange).coerceIn(0f, 1f)
    }

    CollapsingImageLayout(
        collapseFractionProvider = collapseFractionProvider,
        modifier = HzPadding.then(Modifier.statusBarsPadding())
    ) {
        ProductImage(
            imageUrl = imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun CollapsingImageLayout(
    collapseFractionProvider: () -> Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        check(measurables.size == 1)

        val collapseFraction = collapseFractionProvider()

        val imageMaxSize = min(ExpandedImageSize.roundToPx(), constraints.maxWidth)
        val imageMinSize = max(CollapsedImageSize.roundToPx(), constraints.minWidth)
        val imageWidth = androidx.compose.ui.util.lerp(imageMaxSize, imageMinSize, collapseFraction)
        val imagePlaceable = measurables[0].measure(Constraints.fixed(imageWidth, imageWidth))

        val imageY = lerp(MinTitleOffset, MinImageOffset, collapseFraction).roundToPx()
        val imageX = androidx.compose.ui.util.lerp(
            (constraints.maxWidth - imageWidth) / 2, // centered when expanded
            constraints.maxWidth - imageWidth, // right aligned when collapsed
            collapseFraction
        )
        layout(
            width = constraints.maxWidth,
            height = imageY + imageWidth
        ) {
            imagePlaceable.placeRelative(imageX, imageY)
        }
    }
}

@Composable
private fun CartBottomBar(modifier: Modifier = Modifier) {
    val (count, updateCount) = remember { mutableStateOf(1) }
    GratisSurface(modifier) {
        Column {
            GratisDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .navigationBarsPadding()
                    .then(HzPadding)
                    .heightIn(min = BottomBarHeight)
            ) {
                QuantitySelector(
                    count = count,
                    decreaseItemCount = { if (count > 0) updateCount(count - 1) },
                    increaseItemCount = { updateCount(count + 1) }
                )
                Spacer(Modifier.width(16.dp))
                GratisButton(
                    onClick = { /* todo */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.add_to_cart),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

