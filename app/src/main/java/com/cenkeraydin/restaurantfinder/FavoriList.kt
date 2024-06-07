package com.cenkeraydin.restaurantfinder

import androidx.compose.runtime.mutableStateListOf
import com.cenkeraydin.restaurantfinder.data.Restaurant

class FavoriList {
    companion object{
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
}