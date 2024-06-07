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

    val populerDishDurumle= listOf(
        "Adana Dürümle",
        "Soslu Tavuk Dürümle",
        "Urfa Dürümle"
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
    val populerDishPopeyes = listOf(
        "Maxi Menü",
        "Popchicken Menü",
        "XL Tavuk Menü"
    )
    val populerDishTaco= listOf(
        "Cantina Chicken Crispy Taco",
        "Soft Taco Supreme",
        "Crunchy Taco"
    )

    val  restaurants : SnapshotStateList<Restaurant> = mutableStateListOf(
        Restaurant("Adana Kebap", R.drawable.adanakebap, 25.0, "11.05.2022", false,"Konyaaltı / Antalya","4.3/5",populerDishAdanaKebap),
        Restaurant("Dürümle", R.drawable.durumle, 15.0, "12.07.2023", false,"Kepez / Antalya","4.0/5",populerDishDurumle),
        Restaurant("Angus Burger", R.drawable.angusburger, 32.0, "12.01.2020", false, "Kepez / Antalya","3.5/5",populerDishAngusBurger),
        Restaurant("BurgerHome", R.drawable.burgerhome, 50.0, "17.02.2023", false,"Kemer / Antalya","3.4/5",populerDishBurgerHome),
        Restaurant("Ev Yemekleri", R.drawable.evyemekleri, 10.0, "24.11.2021", false,"Gazipaşa / Antalya","4.2/5",populerDishEvYemekleri),
        Restaurant("Popeyes", R.drawable.popeyes, 30.0, "23.04.2021", false,"Gazipaşa / Antalya","4.7/5",populerDishPopeyes),
        Restaurant("Taco Bell", R.drawable.tacobell, 35.0, "19.02.2018", false,"Gazipaşa / Antalya","4.0/5",populerDishTaco),

        )

    fun getFavoriList(): SnapshotStateList<Restaurant>{
        return FavoriList.favoriteRestaurants

    }

    var favoriteRestaurants = getFavoriList()

    fun addToFavorite(restaurant: Restaurant) {
        if (!favoriteRestaurants.contains(restaurant)) {
            favoriteRestaurants.add(restaurant)
            favoriteRestaurants=getFavoriList()
        }
    }

    fun removeFromFavorite(restaurant: Restaurant) {
        FavoriList.removeFromFavorite(restaurant)
        favoriteRestaurants.remove(restaurant)

    }

    fun toggleFavorite(restaurant: Restaurant) {
        restaurant.isFavorite = !restaurant.isFavorite
        if (favoriteRestaurants.contains(restaurant)) {
            removeFromFavorite(restaurant)
            restaurant.isFavorite=false
        } else {
            addToFavorite(restaurant)
            restaurant.isFavorite=true
        }


    }
}