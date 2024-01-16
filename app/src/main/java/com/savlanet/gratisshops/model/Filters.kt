package com.savlanet.gratisshops.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector

@Stable
class Filter(
    val name: String,
    enabled: Boolean = false,
    val icon: ImageVector? = null
) {
    val enabled = mutableStateOf(enabled)
}
val filters = listOf(
    Filter(name = "Lifestyle"),
    Filter(name = "Pastries"),
    Filter(name = "Dairy-free"),
    Filter(name = "Street style"),
    Filter(name = "Appliances"),
    Filter(name = "Gaming"),
    Filter(name = "Culture"),
    Filter(name = "Make Up"),
    Filter(name = "Turbans"),
    Filter(name = "Organic")

)
val priceFilters = listOf(
    Filter(name = "0"),
    Filter(name = "00"),
    Filter(name = "000"),
    Filter(name = "0000"),
    Filter(name = "00000")

)
val dateFilters = listOf(
    Filter(name = "This month"),
    Filter(name = "Last week"),
    Filter(name = "Today"),
    Filter(name = "An hour ago"),
    Filter(name = "Now")

)
val sortFilters = listOf(
    Filter(name = "GratisShops favorite (default)", icon = Icons.Filled.AutoMode),
    Filter(name = "Rating", icon = Icons.Filled.Star),
    Filter(name = "Recently added", icon = Icons.Filled.NewReleases),
    Filter(name = "Alphabetical", icon = Icons.Filled.SortByAlpha)
)

val categoryFilters = listOf(
    Filter(name = "Clothes"),
    Filter(name = "Books"),
    Filter(name = "Computers"),
    Filter(name = "Homemade food"),
    Filter(name = "Farm Produce"),
    Filter(name = "Jewellery"),
    Filter(name = "Children Toys"),
    Filter(name = "Furniture")


)
val VarietyFilters = listOf(
    Filter(name = "Lifestyle"),
    Filter(name = "Pastries"),
    Filter(name = "Dairy-free"),
    Filter(name = "Street style"),
    Filter(name = "Appliances"),
    Filter(name = "Gaming"),
    Filter(name = "Culture"),
    Filter(name = "MakeUp"),
    Filter(name = "Turbans"),
    Filter(name = "Organic")
)

var sortDefault = sortFilters.get(0).name

