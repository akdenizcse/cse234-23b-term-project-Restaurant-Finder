package com.cenkeraydin.restaurantfinder.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cenkeraydin.restaurantfinder.R
import com.cenkeraydin.restaurantfinder.ui.theme.GrayColor
import com.cenkeraydin.restaurantfinder.ui.theme.Primary
import com.cenkeraydin.restaurantfinder.ui.theme.Secondary
import com.cenkeraydin.restaurantfinder.ui.theme.TextColor

@Composable
fun TextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center,
        color = colorResource(R.color.colorText)
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ), textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextField(labelValue: String, imageVector: ImageVector, value: String, onValueChange: (String) -> Unit) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = {
            Text(text = labelValue)
        },
        value = value,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = "Account Icon",
                tint = Color.Black
            )
        })
}

@Composable
fun PasswordTextField(
    labelValue: String,
    imageVector: ImageVector,
    value: String,
    onValueChange: (String) -> Unit
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        label = {
            Text(text = labelValue)
        },
        value = value,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = "",
                tint = Color.Black
            )
        },
        trailingIcon = {
            val iconImage = if (passwordVisible) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible) {
                stringResource(R.string.hide_password)
            } else {
                stringResource(R.string.show_password)
            }

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}


@Composable
fun ButtonComponent(value: String, navController: NavController, isEnabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun DividerTextComponent(){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color= GrayColor,
            thickness=1.dp
        )

        Text(modifier = Modifier.padding(8.dp),text = "or", fontSize = 18.sp, color = TextColor)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color= GrayColor,
            thickness=1.dp
        )
    }
}

@Composable
fun Login(navController: NavController) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {


        Text(text = buildAnnotatedString {
            append("Already have an account ")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("login")
            }
        },
            modifier = Modifier
                .clickable { navController.navigate("LoginScreen") }
        )
    }
}

@Composable
fun Register(navController: NavController) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {


        Text(text = buildAnnotatedString {
            append("Already have an account ")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Register")
            }
        },
            modifier = Modifier
                .clickable { navController.navigate("SignUpScreen") }
        )
    }
}


