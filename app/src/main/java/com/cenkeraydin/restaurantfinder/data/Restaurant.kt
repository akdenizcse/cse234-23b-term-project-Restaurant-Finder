package com.cenkeraydin.restaurantfinder.data

import androidx.annotation.DrawableRes

data class Restaurant(
    val name: String,
    @DrawableRes val image: Int,
    val price: Double,
    val date: String,
    var isFavorite: Boolean,
    val location: String,
    val popularDishes: List<String>
)

