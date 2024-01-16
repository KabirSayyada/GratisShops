package com.savlanet.gratisshops.model

import androidx.compose.runtime.Immutable

data class ProductCollection(
    val id: Long,
    val name: String,
    val products: List<Product>,
    val type: CollectionType = CollectionType.Normal
)

enum class CollectionType { Normal, Highlight }

/**
 * A fake repo
 */
object ProductRepo {
    fun getProducts(): List<ProductCollection> = productCollections
    fun getProduct(productId: Long) = products.find { it.id == productId }!!
    fun getRelated(@Suppress("UNUSED_PARAMETER") productId: Long) = related
    fun getInspiredByCart() = inspiredByCart
    fun getFilters() = filters
    fun getPriceFilters() = priceFilters
    fun getDateFilters() = dateFilters
    fun getCart() = cart
    fun getSortFilters() = sortFilters
    fun getCategoryFilters() = categoryFilters
    fun getSortDefault() = sortDefault
    fun getLifeStyleFilters() = VarietyFilters
}

/**
 * Static data
 */
private val forYou = ProductCollection(
    id = 1L,
    name = "For YOU",
    type = CollectionType.Normal,
    products = products.subList(0, 10),

    )


private val tastyTreats = ProductCollection(
    id = 2L,
    name = "Tasty Treats",
    type = CollectionType.Highlight,
    products = products.subList(10, 20),

)

private val fashion = ProductCollection(
    id = 3L,
    name = "Traditional Street Wears",
    type = CollectionType.Normal,
    products = products.subList(20, 25)

)

private val yourArea = forYou.copy(
    id = 4L,
    name = "Trending in your area",
    type = CollectionType.Highlight


)

private val popular = ProductCollection(
    id = 5L,
    name = "Popular on Gratis Shops",
    type = CollectionType.Normal,
    products = products.subList(25, 30),
)

private val wfhFavs = tastyTreats.copy(
    id = 6L,
    name = "Users Favourites",
    type = CollectionType.Highlight
)

private val newlyAdded = popular.copy(
    id = 7L,
    name = "Recently Added"
)

private val exclusive = fashion.copy(
    id = 8L,
    name = "Only on Gratis Shops",
    type = CollectionType.Highlight
)

private val also = yourArea.copy(
    id = 9L,
    name = "Customers also bought"
)

private val inspiredByCart = forYou.copy(
    id = 10L,
    name = "Inspired by your cart"
)


private val productCollections = listOf(
    forYou,
    tastyTreats,
    fashion,
    yourArea,
    popular,
    wfhFavs,
    newlyAdded,
    exclusive
)

private val related = listOf(
    also,
    popular
)

private val cart = listOf(
    OrderLine(products[4], 3),
    OrderLine(products[6], 4),
    OrderLine(products[8], 2)
)

@Immutable
data class OrderLine(
    val product: Product,
    val count: Int
)
