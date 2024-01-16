package com.savlanet.gratisshops.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.savlanet.gratisshops.R

@Immutable
data class Vendor(
    val id: Long,
    val vendorName: String,
    @DrawableRes val vendorImage: Int,
    val business: String,
    val lastSeen: String = "",
    val explore: String,
    val soldToday: String = "",
    val verified: Boolean = false
)

val vendors = listOf(
    Vendor(
        id = 1L,
        vendorImage =  R.drawable.ngozi,
        vendorName = "Fatima",
        business = "Sells Jewellery",
        lastSeen = "active 4 minutes ago",
        soldToday = "sold 20 Earrings today",
        explore = "Explore Fatimas shop",
        verified = true
    ),
    Vendor(
        id = 2L,
        vendorImage = R.drawable.chioms,
        vendorName = "Ngozi",
        business = "Chef",
        lastSeen = "Active 4 minutes ago",
        soldToday = "Sold 55 cakes today",
        explore = "Explore Fatima's shop",
        verified = true
    ),
    Vendor(
        id = 3L,
        vendorImage = R.drawable.faruk,
        vendorName = "Faruk",
        business = "Sells Game Consoles",
        lastSeen = "active 10 minutes ago",
        soldToday = "Sold 4 Play Stations today",
        explore = "Explore Faruk's shop",
    ),
    Vendor(
        id = 4L,
        vendorImage = R.drawable.jessica,
        vendorName = "Jessica",
        business = "Sells Books",
        lastSeen = "Active now",
        soldToday = "Sold 18 Novels today",
        explore = "Explore Jessica's shop",
    ),
    Vendor(
        id = 5L,
        vendorImage = R.drawable.aiden,
        vendorName = "Aiden",
        business = "Sells Toys",
        lastSeen = "active 40 minutes ago",
        soldToday = "Sold 30 Legos today to kids around the world",
        explore = "Explore Aiden's shop",
        verified = true
    ),
    Vendor(
        id = 6L,
        vendorImage = R.drawable.tom,
        vendorName = "Tom",
        business = "Carpenter",
        lastSeen = "active 2 minutes ago",
        soldToday = "Sold 4 Sofas today ",
        explore = "Explore Tom's shop",
        verified = true
    ),
    Vendor(
        id = 7L,
        vendorImage = R.drawable.olanrewaju,
        vendorName = "Olanrewaju",
        business = "Sells Fresh Fruits",
        lastSeen = "active now",
        soldToday = "sold a record of 300 Melons today",
        explore = "Explore Olanrewaju's shop",
    ),
    Vendor(
        id = 8L,
        vendorImage = R.drawable.ngozi,
        vendorName = "Ngozi",
        business = "Sells African Attires",
        lastSeen = "active now",
        soldToday = "sold 8 Ankaras today",
        explore = "Explore Ngozi's shop",
        verified = true
    ),
    Vendor(
        id = 9L,
        vendorImage = R.drawable.chioms,
        vendorName = "Chioma",
        business = "Sells Footwear",
        lastSeen = "active an hour ago",
        soldToday = "Managed to sell 92 shoes today",
        explore = "Explore Chioma's shop",
    ),
    Vendor(
        id = 10L,
        vendorImage = R.drawable.musa,
        vendorName = "Musa",
        business = "Sells Bangles",
        lastSeen = "active 4 hours ago",
        soldToday = "sold 1 bangle today",
        explore = "Explore Musa's shop",
    ),
    Vendor(
        id = 11L,
        vendorImage = R.drawable.ngozi,
        vendorName = "Shemau",
        business = "Chef",
        lastSeen = "active 30 minutes",
        soldToday = "Able to sell 60 Muffins today",
        explore = "Explore Shemau's shop",
    )

)