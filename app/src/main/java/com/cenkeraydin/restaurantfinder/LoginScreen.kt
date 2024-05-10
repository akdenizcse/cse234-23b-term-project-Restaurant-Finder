package com.cenkeraydin.restaurantfinder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(navControler: NavController){

    var email by remember{ mutableStateOf("") }

    var password by remember { mutableStateOf("") }
    BackButton(navController = navControler)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.images),
            contentDescription = "login image",
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = stringResource(R.string.project_name),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Login to your account"
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange ={
                email=it
            },
            label = {
                Text(text = "Email")
            })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange ={
                password=it
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick ={
            navControler.navigate("HomeScreen")
        }) {
            Text("Login")

        }
        Spacer(modifier = Modifier.height(32.dp))

        TextButton(onClick = { }){
            Text(text = "Forgot Password")
        }



    }
}
@Composable
fun BackButton(
    navController: NavController,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.ArrowBackIosNew,
    contentDescription: String = "Back"
) {
    Row(modifier = modifier) {
        IconButton(
            onClick = { navController.navigate("EntryScreen") },
            Modifier.safeContentPadding()
        ) {
            Icon(icon, contentDescription)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevLoginScreen(){
    Proje1Theme {
        var navController = rememberNavController()
        LoginScreen(navControler = navController)
    }
}