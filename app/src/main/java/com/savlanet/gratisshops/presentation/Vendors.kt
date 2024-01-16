package com.savlanet.gratisshops.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Verified
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.savlanet.gratisshops.R
import com.savlanet.gratisshops.components.GratisCard
import com.savlanet.gratisshops.components.GratisDivider
import com.savlanet.gratisshops.components.GratisSurface
import com.savlanet.gratisshops.components.GratisVerificationIcon
import com.savlanet.gratisshops.model.Product
import com.savlanet.gratisshops.model.Vendor
import com.savlanet.gratisshops.model.vendors
import com.savlanet.gratisshops.ui.theme.Amber700
import com.savlanet.gratisshops.ui.theme.Poppins
import com.savlanet.gratisshops.ui.theme.Purple700
import com.savlanet.gratisshops.ui.theme.Teal200


@Composable
fun VendorsList(
    //vendors: List<Vendor>,
    modifier: Modifier = Modifier
) {

        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ) {
            item {
                TopAppBar(
                    title = {
                        Text(
                            text = "GratisShops Vendors",
                            fontFamily = Poppins,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,

                            ) },
                    backgroundColor = Color.White
                )
            }
            items(vendors) { vendor ->
                VendorItem(vendor)
        }
            item{
                Text(text = "", modifier = Modifier.padding(top = 35.dp))
            }
    }
}


@Composable
private fun VendorItem(
    vendor: Vendor
) {

    GratisCard(
        modifier = Modifier
            .wrapContentSize()
            .padding(bottom = 4.dp, top = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Row {
                VendorImage(
                    imageUrl = vendor.vendorImage,
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                )
                if (vendor.verified) {
                    GratisVerificationIcon(
                        imageVector = Icons.Default.Verified,
                        contentDescription = "Verification Icon",
                        modifier = Modifier
                            .padding(start = 4.dp, top = 8.dp)
                            .size(25.dp)
                    )
                }else{
                    Text("")
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = vendor.vendorName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Purple700

            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = vendor.business,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Amber700,
            )
        GratisDivider()
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = vendor.soldToday,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = Poppins
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = vendor.lastSeen,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = Poppins,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(
                onClick = {  },
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentSize(),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 1.dp,
                    disabledElevation = 0.dp
                ),
                shape = RoundedCornerShape(50)
            ) {
                Text(
                    text = vendor.explore,
                    style = TextStyle(color = MaterialTheme.colors.primary),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
        GratisDivider(thickness = 4.dp)

    }
}


@Composable
private fun VendorsImage(
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

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            placeholder = painterResource(R.drawable.profile_icon),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(Color.Gray),
            modifier = Modifier
                .border(width = 1.5.dp, color = Color.LightGray, shape = CircleShape)
        )
    }
}
