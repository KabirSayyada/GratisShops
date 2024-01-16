package com.savlanet.gratisshops.presentation.search

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.savlanet.gratisshops.model.Filter
import com.savlanet.gratisshops.model.Product
import com.savlanet.gratisshops.R
import com.savlanet.gratisshops.components.*
import com.savlanet.gratisshops.model.products
import com.savlanet.gratisshops.presentation.ProductImage
import com.savlanet.gratisshops.presentation.VendorImage
import com.savlanet.gratisshops.ui.theme.GratisShopsTheme

@Composable
fun SearchResults(
    searchResults: List<Product>,
    filters: List<Filter>,
    onProductClick: (Long) -> Unit
) {
    Column {
        FilterBar(filters, onShowFilters = {})
        Text(
            text = stringResource(R.string.search_count, searchResults.size),
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
        )
        LazyColumn {
            itemsIndexed(searchResults) { index, snack ->
                SearchResult(snack, onProductClick, index != 0)
            }
        }
    }
}

@Composable
private fun SearchResult(
    product: Product,
    onSnackClick: (Long) -> Unit,
    showDivider: Boolean,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onSnackClick(product.id) }
            .padding(horizontal = 24.dp)
    ) {
        val (divider, image, name, tag, priceSpacer, price, add, from, venImage, verification) = createRefs()
        createVerticalChain(name, tag, priceSpacer, price, chainStyle = ChainStyle.Packed)
        if (showDivider) {
            GratisDivider(
                Modifier.constrainAs(divider) {
                    linkTo(start = parent.start, end = parent.end)
                    top.linkTo(parent.top)
                }
            )
        }
        ProductImage(
            imageUrl = product.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .constrainAs(image) {
                    linkTo(
                        top = parent.top,
                        topMargin = 16.dp,
                        bottom = parent.bottom,
                        bottomMargin = 16.dp
                    )
                    start.linkTo(parent.start)
                }
        )
        Text(
            text = product.name,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.constrainAs(name) {
                linkTo(
                    start = image.end,
                    startMargin = 16.dp,
                    end = add.start,
                    endMargin = 16.dp,
                    bias = 0f
                )
            }
        )
        Text(
            text = "",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.constrainAs(tag) {
                linkTo(
                    start = image.end,
                    startMargin = 16.dp,
                    end = add.start,
                    endMargin = 16.dp,
                    bias = 0f
                )
            }
        )
        Spacer(
            Modifier
                .height(8.dp)
                .constrainAs(priceSpacer) {
                    linkTo(top = tag.bottom, bottom = price.top)
                }
        )
        Text(
            text = "${product.price} Naira",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.constrainAs(price) {
                linkTo(
                    start = image.end,
                    startMargin = 16.dp,
                    end = add.start,
                    endMargin = 16.dp,
                    bias = 0f
                )
            }
        )
        GratisButton(
            onClick = { /* todo */ },
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .size(36.dp)
                .constrainAs(add) {
                    linkTo(top = parent.top, bottom = parent.bottom)
                    end.linkTo(parent.end)
                }
        ) {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = stringResource(R.string.label_add)
            )
        }
        Text(
            text = product.vendorName,
            style = MaterialTheme.typography.overline,
            color = Color.Gray,
            modifier = Modifier.constrainAs(from) {
                top.linkTo(image.bottom)
                start.linkTo(parent.start)

            }
        )
        VendorImage(
            imageUrl = product.vendorImage,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .constrainAs(venImage) {
                    start.linkTo(from.start)
                }
        )
        if (product.verified) {
            GratisVerificationIcon(
                imageVector = Icons.Default.Verified,
                contentDescription = "Verification Icon",
                modifier = Modifier
                    .constrainAs(verification) {
                        start.linkTo(venImage.end)
                    }
                    .padding(start = 2.dp,)
                    .size(16.dp)
            )
        }else{
            Text("")
        }
    }
}

@Composable
fun NoResults(
    query: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize()
            .padding(24.dp)
    ) {
        Image(
            painterResource(R.drawable.empty_state_search),
            contentDescription = null
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.search_no_matches, query),
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.search_no_matches_retry),
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
private fun SearchResultPreview() {
    GratisShopsTheme {
        GratisSurface {
            SearchResult(
                product = products[0],
                onSnackClick = { },
                showDivider = false
            )
        }
    }
}
