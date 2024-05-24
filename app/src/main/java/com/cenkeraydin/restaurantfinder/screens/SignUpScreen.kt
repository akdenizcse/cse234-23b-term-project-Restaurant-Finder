package com.cenkeraydin.restaurantfinder.screens
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cenkeraydin.restaurantfinder.R
import com.cenkeraydin.restaurantfinder.components.ButtonComponent
import com.cenkeraydin.restaurantfinder.components.DividerTextComponent
import com.cenkeraydin.restaurantfinder.components.HeadingTextComponent
import com.cenkeraydin.restaurantfinder.components.Login
import com.cenkeraydin.restaurantfinder.components.MyTextField
import com.cenkeraydin.restaurantfinder.components.TextComponent
import com.cenkeraydin.restaurantfinder.components.PasswordTextField
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun SignUpScreen(navController: NavController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    val auth=FirebaseAuth.getInstance()
    val currentUser= FirebaseAuth.getInstance().currentUser
    val firestore= FirebaseFirestore.getInstance()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {


            TextComponent(value = stringResource(id = R.string.hello))

            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(16.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.first_name),
                imageVector = Icons.Default.Person,
                value= firstName,
                onValueChange = { firstName=it}
            )
            Spacer(modifier = Modifier.height(8.dp))

            MyTextField(
                labelValue = stringResource(id = R.string.last_name),
                imageVector = Icons.Default.Person,
                value = lastName,
                onValueChange = {lastName=it}
            )
            Spacer(modifier = Modifier.height(8.dp))

            MyTextField(
                labelValue = stringResource(id = R.string.email),
                imageVector = Icons.Default.Email,
                value= email,
                onValueChange = { email =it}
            )
            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                imageVector = Icons.Default.Lock,
                value = password,
                onValueChange = { password = it}
            )
            Spacer(modifier = Modifier.height(8.dp))
            PasswordTextField(
                labelValue = stringResource(id = R.string.passwordConfirm),
                imageVector = Icons.Default.Lock,
                value = confirmPassword,
                onValueChange = { confirmPassword = it}
            )
            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(
                value = stringResource(id = R.string.register),
                navController,
                isEnabled = email.isNotEmpty()&& password.isNotEmpty()) {
                if (password == confirmPassword) {
                    isLoading = true
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            isLoading = false
                            if (task.isSuccessful) {
                                message = "Registration successful!"
                                currentUser?.uid?.let { userId ->
                                    val userMap = hashMapOf(
                                        "name" to firstName,
                                        "lastName" to lastName,
                                        "email" to email,
                                        "password" to password
                                    )

                                    firestore.collection("users").document(userId)
                                        .set(userMap).addOnSuccessListener {  }.addOnFailureListener {  }
                                }
                                navController.navigate("HomeScreen") // Kayıt başarılı olduğunda yönlendir
                            } else {
                                message = task.exception?.message ?: "Registration failed"
                                Log.e("RegisterScreen", "Registration failed: ${task.exception}")
                            }
                        }
                } else {
                    message = "Passwords do not match"
                    Log.e("RegisterScreen", "Passwords do not match")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            if (message.isNotEmpty()) {
                Text(text = message)
            }

            DividerTextComponent()
            Login(navController = navController)
        }

    }
}