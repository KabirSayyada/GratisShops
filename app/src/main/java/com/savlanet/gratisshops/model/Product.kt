package com.savlanet.gratisshops.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.savlanet.gratisshops.R

@Immutable
data class Product(
    val id: Long,
    val name: String,
    val imageUrl: String,
    @DrawableRes val vendorImage: Int,
    val vendorName: String,
    val price: Long,
    val tagLine: String = "",
    val tags: Set<String> = emptySet(),
    val verified: Boolean = false
)


val products = listOf(
    Product(
        id = 1L,
        name = "Necklace",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1602173574767-37ac01994b2a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
        vendorImage = R.drawable.ngozi,
        vendorName = "Fatima",
        price = 20000,
        verified = true
    ),
    Product(
        id = 2L,
        name = "Gaming Gears",
        tagLine = "From vendor",
        imageUrl = "https://media.istockphoto.com/photos/flying-gamer-gears-like-mouse-keyboard-joystick-headset-vr-microphone-picture-id1329045610?b=1&k=20&m=1329045610&s=170667a&w=0&h=0g2xPf4oyGVbLvET3ijeEpk4Jh1BXNgEnp-ixU2YY5Y=",
        vendorImage = R.drawable.faruk,
        vendorName = "Faruk",
        price = 4000,
    ),
    Product(
        id = 3L,
        name = "Books",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1656266724376-d8c5afed26d4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fHplcm8lMjB0byUyMG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
        vendorImage = R.drawable.jessica,
        vendorName = "Jessica",
        price = 8000
    ),
    Product(
        id = 4L,
        name = "Toys",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1558060370-d644479cb6f7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fHRveXN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
        vendorImage = R.drawable.aiden,
        vendorName = "Aiden",
        price = 5500,
        verified = true
    ),
    Product(
        id = 5L,
        name = "Couch",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1596900779744-2bdc4a90509a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=938&q=80",
        vendorImage = R.drawable.tom,
        vendorName = "Tom",
        price = 20000,
        verified = true
    ),
    Product(
        id = 6L,
        name = "Fresh Fruits",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1519996529931-28324d5a630e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
        vendorImage = R.drawable.olanrewaju,
        vendorName = "Olanrewaju",
        price = 500
    ),
    Product(
        id = 7L,
        name = "African Attires",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1481325545291-94394fe1cf95?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=746&q=80",
        vendorImage = R.drawable.ngozi,
        vendorName = "Ngozi",
        price = 20000,
        verified = true
    ),
    Product(
        id = 8L,
        name = "Local footwear",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1655102671475-89a76d271d5f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=688&q=80",
        vendorImage = R.drawable.chioms,
        vendorName = "Chioma",
        price = 600
    ),
    Product(
        id = 9L,
        name = "handmade bangles",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1508022909583-69228d7b2f8f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80",
        vendorImage = R.drawable.musa,
        vendorName = "Musa",
        price = 100
    ),
    Product(
        id = 10L,
        name = "Turbans",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1606837731745-2598533fac7a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1246&q=80",
        vendorImage = R.drawable.ngozi,
        vendorName = "Shemau",
        price = 150
    ),
    Product(
        id = 11L,
        name = "Homemade Popcorn",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1505686994434-e3cc5abf1330?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1173&q=80",
        vendorImage = R.drawable.chioms,
        vendorName = "Fatima",
        price = 100,
        verified = true
    ),
    Product(
        id = 12L,
        name = "Doughnut",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1514517521153-1be72277b32f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
        vendorImage = R.drawable.jessica,
        vendorName = "Jessica",
        price = 1000
    ),
    Product(
        id = 13L,
        name = "Cupcake",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1486427944299-d1955d23e34d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
        vendorImage = R.drawable.tom,
        vendorName = "Tom",
        price = 500,
        verified = true
    ),
    Product(
        id = 14L,
        name = "Pizza",
        tagLine = "From Vendor",
        imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cGl6emF8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
        vendorImage = R.drawable.ngozi,
        vendorName = "Fatima",
        price = 4000,
        verified = true
    ),
    Product(
        id = 15L,
        name = "Milkshake",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1624781740834-fbfbf5fd221a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8bWlsa3NoYWtlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
        vendorImage = R.drawable.chioms,
        vendorName = "Chioma",
        price = 1500
    ),
    Product(
        id = 16L,
        name = "Peppered Chicken",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1630564510791-1b8a156ec387?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
        vendorImage = R.drawable.jessica,
        vendorName = "Jessica",
        price = 4500
    ),
    Product(
        id = 17L,
        name = "Homemade soup",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1526401363794-c96708fb8089?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
        vendorImage = R.drawable.ngozi,
        vendorName = "Fatima",
        price = 2100,
        verified = true
    ),
    Product(
        id = 18L,
        name = "Shawarma",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1633896949673-1eb9d131a9b4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=666&q=80",
        vendorImage = R.drawable.chioms,
        vendorName = "Chioma",
        price = 1500
    ),
    Product(
        id = 19L,
        name = "Jollof Rice",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1592119747782-d8c12c2ea267?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
        vendorImage = R.drawable.olanrewaju,
        vendorName = "Olanrewaju",
        price = 500
    ),
    Product(
        id = 20L,
        name = "Grilled fish",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1600699899970-b1c9fadd8f9e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8Z3JpbGxlZCUyMGZpc2h8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
        vendorImage = R.drawable.faruk,
        vendorName = "Faruk",
        price = 5000,
    ),
    Product(
        id = 21L,
        name = "Bubus",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1567401893414-76b7b1e5a7a5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
        vendorImage = R.drawable.jessica,
        vendorName = "Jessica",
        price = 4000
    ),
    Product(
        id = 22L,
        name = "Abaya",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1505339805025-a5ec452332d9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
        vendorImage = R.drawable.faruk,
        vendorName = "Faruk",
        price = 8000,
    ),
    Product(
        id = 23L,
        name = "Atamfa",
        tagLine = "From vendor",
        imageUrl = "https://media.istockphoto.com/id/1208598358/photo/plenty-of-colorful-african-fabrics-in-a-rows.jpg?s=1024x1024&w=is&k=20&c=jexWGbFehQFSVOGKIUZ9VhknU-A2-V164HTicGKSO6A=",
        vendorImage = R.drawable.ngozi,
        vendorName = "Fatima",
        price = 5000,
        verified = true
    ),
    Product(
        id = 24L,
        name = "Kaftan",
        tagLine = "From Vendor",
        imageUrl = "https://images.unsplash.com/photo-1601056639638-c53c50e13ead?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8ZmFicmljfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
        vendorImage = R.drawable.musa,
        vendorName = "Musa",
        price = 5000
    ),
    Product(
        id = 25L,
        name = "Jeans",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1565084888279-aca607ecce0c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
        vendorImage = R.drawable.jessica,
        vendorName = "Shemau",
        price = 1500
    ),
    Product(
        id = 26L,
        name = "Flower",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1604323990536-e5452c0507c1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8Ym91cXVldCUyMG9mJTIwZmxvd2Vyc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
        vendorImage = R.drawable.tom,
        vendorName = "Tom",
        price = 12000,
        verified = true
    ),
    Product(
        id = 27L,
        name = "2nd-hand Jordans",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1579338559194-a162d19bf842?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8c25lYWtlcnN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
        vendorImage = R.drawable.tom,
        vendorName = "Tom",
        price = 15000,
        verified = true
    ),
    Product(
        id = 28L,
        name = "Handbag",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1614179689702-355944cd0918?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8aGFuZGJhZ3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
        vendorImage = R.drawable.jessica,
        vendorName = "Fatima",
        price = 20000,
        verified = true
    ),
    Product(
        id = 29L,
        name = "Fridge",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1571175443880-49e1d25b2bc5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZnJpZGdlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
        vendorImage = R.drawable.ngozi,
        vendorName = "Ngozi",
        price = 80000,
        verified = true
        ),
    Product(
        id = 30L,
        name = "Computer",
        tagLine = "From vendor",
        imageUrl = "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80",
        vendorImage = R.drawable.olanrewaju,
        vendorName = "Olanrewaju",
        price = 150000
    ),
)