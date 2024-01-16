package com.savlanet.gratisshops.model

import androidx.compose.runtime.Immutable
import com.savlanet.gratisshops.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * A fake repo for searching.
 */
object SearchRepo {
    fun getCategories(): List<SearchCategoryCollection> = searchCategoryCollections
    fun getSuggestions(): List<SearchSuggestionGroup> = searchSuggestions

    suspend fun search(query: String): List<Product> = withContext(Dispatchers.Default) {
        delay(600L) // simulate an I/O delay
        products.filter { it.name.contains(query, ignoreCase = true) }
    }
}

@Immutable
data class SearchCategoryCollection(
    val id: Long,
    val name: String,
    val categories: List<SearchCategory>
)

@Immutable
data class SearchCategory(
    val name: String,
    val imageUrl: String
)

@Immutable
data class SearchSuggestionGroup(
    val id: Long,
    val name: String,
    val suggestions: List<String>
)

/**
 * Static data
 */

private val searchCategoryCollections = listOf(
    SearchCategoryCollection(
        id = 0L,
        name = "Categories",
        categories = listOf(
            SearchCategory(
                name = "Books",
                imageUrl = "https://images.unsplash.com/photo-1656266724376-d8c5afed26d4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fHplcm8lMjB0byUyMG9uZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
            ),
            SearchCategory(
                name = "Fruit snacks",
                imageUrl = "https://source.unsplash.com/SfP1PtM9Qa8"
            ),
            SearchCategory(
                name = "Clothes",
                imageUrl = "https://images.unsplash.com/photo-1567401893414-76b7b1e5a7a5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
            ),
            SearchCategory(
                name = "Kicks",
                imageUrl = "https://images.unsplash.com/photo-1579338559194-a162d19bf842?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8c25lYWtlcnN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
            )
        )
    ),
    SearchCategoryCollection(
        id = 1L,
        name = "Lifestyles",
        categories = listOf(
            SearchCategory(
                name = "Flowers",
                imageUrl = "https://images.unsplash.com/photo-1604323990536-e5452c0507c1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8Ym91cXVldCUyMG9mJTIwZmxvd2Vyc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
            ),
            SearchCategory(
                name = "Gluten Free",
                imageUrl = "https://images.unsplash.com/photo-1574484152510-903878da786c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=697&q=80"
            ),
            SearchCategory(
                name = "Computers",
                imageUrl = "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80",
            ),
            SearchCategory(
                name = "Gaming Consoles",
                imageUrl = "https://media.istockphoto.com/photos/flying-gamer-gears-like-mouse-keyboard-joystick-headset-vr-microphone-picture-id1329045610?b=1&k=20&m=1329045610&s=170667a&w=0&h=0g2xPf4oyGVbLvET3ijeEpk4Jh1BXNgEnp-ixU2YY5Y=",
            ),
            SearchCategory(
                name = "Vegiterian",
                imageUrl = "https://source.unsplash.com/IGfIGP5ONV0"
            ),
            SearchCategory(
                name = "Drinks",
                imageUrl = "https://images.unsplash.com/photo-1624781740834-fbfbf5fd221a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8bWlsa3NoYWtlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
            )
        )
    )
)

private val searchSuggestions = listOf(
    SearchSuggestionGroup(
        id = 0L,
        name = "Your Recent searches",
        suggestions = listOf(
            "Yogurt",
            "Seafood",
            "Play Station",
            "Handmade Bangles",
        )
    ),
    SearchSuggestionGroup(
        id = 1L,
        name = "Popular searches Today",
        suggestions = listOf(
            "Casual Wear",
            "Gluten Free",
            "Paleo",
            "Vegan",
            "Vegetables",
            "Foot Wear"
        )
    )
)
