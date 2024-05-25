package com.cenkeraydin.restaurantfinder.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cenkeraydin.restaurantfinder.RestaurantViewModel
import com.cenkeraydin.restaurantfinder.components.HeadingTextComponent

@Composable
fun FavoriteScreen(navController: NavController, viewModel: RestaurantViewModel) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        HeadingTextComponent(value = "My Favorite Restaurants")
        BackButtonForFavorite(navController = navController)
        if (viewModel.favoriteRestaurants.isNotEmpty()) {
            LazyColumn {
                items(viewModel.favoriteRestaurants) { restaurant ->
                    RestaurantItem(
                        restaurant = restaurant,
                        onClick = { /* Handle item click */ },
                        onFavoriteClicked = { viewModel.toggleFavorite(it) }
                    )
                }
            }
        } else {
            Text(text = "Favori restoran yok", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun BackButtonForFavorite(
    navController: NavController,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.ArrowBackIosNew,
    contentDescription: String = "Back"
) {
    Row(modifier = modifier) {
        IconButton(
            onClick = { navController.navigate("HomeScreen") },
            Modifier.safeContentPadding()
        ) {
            Icon(icon, contentDescription)
        }
    }
}

