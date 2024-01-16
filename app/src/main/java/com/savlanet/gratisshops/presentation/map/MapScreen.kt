package com.savlanet.gratisshops.presentation.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.*
import com.savlanet.gratisshops.R



@Composable
fun GratisMapScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //modifier = Modifier
          //  .verticalScroll(rememberScrollState())

    ) {
        Text(
            text = "This section is currently a work in progress, it will contain a map and a User will be able to" +
                    " track their order, see the estimated time of arrival, be notified when the item has arrived" +
                    " as well as view the name and mobile number of the Rider" +
                    " that will be delivering their product. ",
             textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 50.dp, start = 5.dp, end = 5.dp)
        )
       /* Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                ),
        ) {
            val context = LocalContext.current
        val singapore = LatLng(1.35, 103.87)
        val cameraPosition = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(singapore, 10f)
        }
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPosition,
                uiSettings = MapUiSettings(zoomControlsEnabled = true),
                //properties = MapProperties(
                  //  mapStyleOptions = MapStyleOptions.loadRawResourceStyle(context, R.raw.style_json)
                )
                //cameraPositionState = CameraPositionState(
                  //  CameraPosition(
                    //    LatLng(22.5726, 88.3639), 12f, 0f, 0f
                    //)
                //)
            //)
            /*Box(
                modifier = Modifier
                    .rotate(180f)
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Transparent
                            ),
                            startY = 10f
                        ),
                    )
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0x6F202020)
                            ),
                    ),
                    ),
                contentAlignment = Alignment.BottomCenter,
            ) {
            //    MapsBottom()
            }*/
        }*/
    }
}