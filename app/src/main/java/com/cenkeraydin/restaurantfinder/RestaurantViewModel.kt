package com.cenkeraydin.restaurantfinder

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.cenkeraydin.restaurantfinder.data.Restaurant

class RestaurantViewModel : ViewModel() {
    val populerDishAdanaKebap = listOf(
        "Adana Kebap",
        "Lahmacun",
        "Şalgam",
    )

    val populerDishUrfaSofrasi= listOf(
        "Urfa Kebap",
        "Pide",
        "Çiğ Köfte"
    )
    val populerDishAngusBurger = listOf(
        "Angus Special Burger",
        "Cajun Burger",
        "Köfte Burger"
    )
    val populerDishBurgerHome= listOf(
        "Burger Home Special",
        "Et Burger",
        "Tavuk Burger"
    )

    val populerDishEvYemekleri = listOf(
        "Mantı",
        "Kuru fasulye",
        "Elbasan Tava"
    )
    val  restaurants : SnapshotStateList<Restaurant> = mutableStateListOf(
        Restaurant("Adana Kebap", R.drawable.adanakebap, 25.0, "2024-05-11", false,"Konyaaltı / Antalya",populerDishAdanaKebap),
        Restaurant("Urfa Sofrası", R.drawable.urfasofrasi, 2.0, "2024-05-12", false,"Kepez / Antalya",populerDishUrfaSofrasi),
        Restaurant("Angus Burger", R.drawable.angusburger, 32.0, "2024-05-13", false, "Kepez / Antalya",populerDishAngusBurger),
        Restaurant("BurgerHome", R.drawable.burgerhomee, 50.0, "2024-05-14", false,"Kemer / Antalya",populerDishBurgerHome),
        Restaurant("Ev Yemekleri", R.drawable.evyemekleri, 90.0, "2024-05-14", false,"Gazipaşa / Antalya",populerDishEvYemekleri),
    )

    var favoriteRestaurants = mutableStateListOf<Restaurant>()

    fun addToFavorite(restaurant: Restaurant) {
        if (!favoriteRestaurants.contains(restaurant)) {
            favoriteRestaurants.add(restaurant)
        }
    }

    fun removeFromFavorite(restaurant: Restaurant) {
        favoriteRestaurants.remove(restaurant)
    }

    fun toggleFavorite(restaurant: Restaurant) {
        restaurant.isFavorite = !restaurant.isFavorite
        if (restaurant.isFavorite) {
            removeFromFavorite(restaurant)
        } else {
            addToFavorite(restaurant)
        }
    }
}