package com.example.variableentorno.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun Login (navController: NavController){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(modifier = Modifier.height(40.dp))

        Text(
            text = "Log In",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Box(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.width(300.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF5E5CE6),
                unfocusedTextColor = Color(0xFF5E5CE6)
            )
        )

        Box(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.width(300.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF5E5CE6),
                unfocusedTextColor = Color(0xFF5E5CE6)
            )
        )

        Box(modifier = Modifier.height(10.dp))

        Text(
            text = "¿No password? try other options",
            color = Color.Blue,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable { }
        )

        Box(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(55.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color(0xFF5E5CE6)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Log In",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(modifier = Modifier.height(10.dp))

        Text(
            text = "or Sign Up",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Box(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(55.dp)
                .clip(RoundedCornerShape(50.dp))
                .border(1.dp, Color(0xFF5E5CE6), RoundedCornerShape(50.dp))
                .clickable {
                    navController.navigate("Register")
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Sign Up",
                color = Color(0xFF5E5CE6),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
