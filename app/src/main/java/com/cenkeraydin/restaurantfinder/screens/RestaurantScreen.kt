package com.cenkeraydin.restaurantfinder.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cenkeraydin.restaurantfinder.FavoriList
import com.cenkeraydin.restaurantfinder.RestaurantViewModel
import com.cenkeraydin.restaurantfinder.data.Restaurant
import com.google.common.io.Files.append


@Composable
fun RestaurantList(
    restaurants: List<Restaurant>,
    onRestaurantClicked: (Restaurant) -> Unit,
    onFavoriteClicked: (Restaurant) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    Column {
        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            onSearchTextChanged = { searchText = it }
        )
        LazyColumn {
            val filteredRestaurants = restaurants.filter {
                it.name.contains(searchText, ignoreCase = true)
            }
            items(filteredRestaurants) { restaurant ->
                RestaurantItem(
                    restaurant = restaurant,
                    onClick = { onRestaurantClicked(restaurant) },
                    onFavoriteClicked = { updatedRestaurant ->
                        onFavoriteClicked(updatedRestaurant)
                    }
                )
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearchTextChanged: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = {
            text = it
            onSearchTextChanged(it)
        },
        placeholder = { Text(text = "Search...") },
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        }
    )
}

@Composable
fun RestaurantItem(
    restaurant: Restaurant,
    onClick: () -> Unit,
    onFavoriteClicked: (Restaurant) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick),

        ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            FavoriteButton(
                productIsFavorite =  if (FavoriList.favoriteRestaurants.contains(restaurant)) true else false ,
                onFavoriteClicked = {
                    onFavoriteClicked(restaurant.copy(isFavorite = it))
                }
            )
            Image(
                painter = painterResource(id = restaurant.image),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Column(
                modifier = Modifier.fillMaxSize().fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = restaurant.name, style = TextStyle(fontSize = 20.sp))
                Text(text = "Price: $${restaurant.price}", style = TextStyle(fontSize = 16.sp))
                Text(text = "Rating: ${restaurant.rating}", style = TextStyle(fontSize = 16.sp))

            }
        }

    }
}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    productIsFavorite: Boolean,
    onFavoriteClicked: (favorite: Boolean) -> Unit
) {

    var isFavorite by rememberSaveable { mutableStateOf(productIsFavorite) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = it
            onFavoriteClicked(it)
        }
    ) {
        Icon(
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetail(restaurant: Restaurant, onBackClicked: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = restaurant.name)
                },
                navigationIcon = {
                    IconButton(onClick = onBackClicked) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = restaurant.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) {
                    append("Name: ")
                }
                withStyle(style = SpanStyle(fontSize = 20.sp)) {
                    append(restaurant.name)
                }
            })
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) {
                    append("Price: ")
                }
                withStyle(style = SpanStyle(fontSize = 20.sp)) {
                    append("$${restaurant.price}")
                }
            })
            Spacer(modifier = Modifier.height(8.dp))
            Text( text = buildAnnotatedString { withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) {
                append("Date: ")
            }
                    withStyle(style = SpanStyle(fontSize = 20.sp)) {
                append(restaurant.date)
            }
            })
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = buildAnnotatedString { withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) {
                append("Location: ")
            }
                withStyle(style = SpanStyle(fontSize = 20.sp)) {
                    append(restaurant.location)
                }
            })
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline, fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                        append("Popular Dishes")
                    }
                },
                style = TextStyle(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            restaurant.popularDishes.forEach { dish ->
                Text(text = dish, style = TextStyle(fontSize = 16.sp))
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApps(restaurantViewModel: RestaurantViewModel, paddingValues: PaddingValues) {
    var selectedRestaurant by remember { mutableStateOf<Restaurant?>(null) }

    Column(modifier = Modifier.padding(paddingValues)) {
        if (selectedRestaurant == null) {
            RestaurantList(
                restaurants = restaurantViewModel.restaurants,
                onRestaurantClicked = { restaurant ->
                    selectedRestaurant = restaurant
                },
                onFavoriteClicked = { restaurant ->
                    restaurantViewModel.toggleFavorite(restaurant)


                }
            )
        } else {
            RestaurantDetail(restaurant = selectedRestaurant!!) {
                selectedRestaurant = null
            }
        }
    }
}




