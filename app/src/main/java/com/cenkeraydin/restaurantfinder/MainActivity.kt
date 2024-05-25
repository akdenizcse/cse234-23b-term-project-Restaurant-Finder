package com.cenkeraydin.restaurantfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cenkeraydin.restaurantfinder.screens.EntryScreen
import com.cenkeraydin.restaurantfinder.screens.FavoriteScreen
import com.cenkeraydin.restaurantfinder.screens.HomeScreen
import com.cenkeraydin.restaurantfinder.screens.LoginScreen
import com.cenkeraydin.restaurantfinder.screens.SignUpScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    private val auth: FirebaseAuth by lazy { Firebase.auth }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val viewModel: RestaurantViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "EntryScreen") {
        composable("EntryScreen") {
            EntryScreen(navController = navController)
        }
        composable("LoginScreen") {
            LoginScreen(navController)
        }
        composable("SignUpScreen") {
            SignUpScreen(navController)
        }
        composable("HomeScreen"){
            HomeScreen(navController = navController,viewModel)
        }
        composable("FavoriteScreen"){
            FavoriteScreen(navController,viewModel)
        }

    }
}



