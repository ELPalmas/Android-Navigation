package com.example.variableentorno.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController


@Composable
fun Register (navController: NavController){

    var email by remember { mutableStateOf("") }
    var nameUser by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var reapeatPassword by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf(false) }
    fun isValidEmail (email:String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    var nameError by remember { mutableStateOf(false) }
    fun isValidName(nameUser: String): Boolean {
        return nameUser.matches(Regex("^[a-zA-Z ]+$"))
    }

    var telefonoError by remember { mutableStateOf(false) }
    fun isValidTelefono(telefono: String): Boolean {
        return telefono.matches(Regex("^\\d{10}$"))
    }

    val isValidFormulario =
        nameUser.isNotEmpty() && !nameError &&
                email.isNotEmpty() && !emailError &&
                telefono.isNotEmpty() && !telefonoError &&
                password.isNotEmpty() &&
                reapeatPassword.isNotEmpty() &&
                password == reapeatPassword

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
            text = "Sing Up",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Box(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = nameUser,
            onValueChange = {
                nameUser = it
                nameError = !isValidName(it) },
            label = { Text("Name User") },
            isError = nameError,
            modifier = Modifier.width(300.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF5E5CE6),
                unfocusedTextColor = Color(0xFF5E5CE6)
            )
        )

        Box(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                emailError = !isValidEmail(email = it)
            },
            label = { Text("Email") },
            isError = emailError,
            modifier = Modifier.width(300.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF5E5CE6),
                unfocusedTextColor = Color(0xFF5E5CE6)
            )
        )

        Box(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = telefono,
            onValueChange = {
                telefono = it
                telefonoError = !isValidTelefono(telefono = it)
            },
            label = { Text("telefono") },
            isError = telefonoError,
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

        Box(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = reapeatPassword,
            onValueChange = { reapeatPassword = it },
            label = { Text("Repeat Password") },
            isError = reapeatPassword.isNotEmpty() && password != reapeatPassword,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.width(300.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF5E5CE6),
                unfocusedTextColor = Color(0xFF5E5CE6)
            )
        )

        Box(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            enabled = isValidFormulario,
            modifier = Modifier
                .width(200.dp)
                .height(55.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5E5CE6)
            )
        ) {
            Text(
                text = "Sign Up",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(modifier = Modifier.height(10.dp))

        Text(
            text = "or Log In",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Box(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = { navController.navigate("login") },
            modifier = Modifier
                .width(200.dp)
                .height(55.dp),
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(1.dp, Color(0xFF5E5CE6)),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(
                text = "Log In",
                color = Color(0xFF5E5CE6),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}