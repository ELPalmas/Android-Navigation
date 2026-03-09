package com.example.variableentorno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.variableentorno.ui.theme.VariableEntornoTheme

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VariableEntornoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    register()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VariableEntornoTheme {
        Greeting("Android")
    }
}

@Composable
fun MainBody() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier.height(40.dp))

        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        )

        Box(modifier = Modifier.height(24.dp))

        Text(
            text = "Hello",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Box(modifier = Modifier.height(8.dp))

        Text(
            text = "Bienvenido a la aplicacion",
            fontSize = 20.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Box(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(55.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color(0xFF5E5CE6)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(55.dp)
                .clip(RoundedCornerShape(50.dp))
                .border(1.dp, Color(0xFF5E5CE6), RoundedCornerShape(50.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Sign Up",
                color = Color(0xFF5E5CE6),
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(modifier = Modifier.height(24.dp))

        Text(
            text = "Sign up using",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Box(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            SingUpUsing(R.drawable.face)
            SingUpUsing(R.drawable.gplus)
            SingUpUsing(R.drawable.`in`)
        }
    }
}

@Composable
fun SingUpUsing(icon: Int) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier.size(50.dp)
    )
}

@Composable
fun Login (){

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
                .border(1.dp, Color(0xFF5E5CE6), RoundedCornerShape(50.dp)),
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


@Composable
fun register (){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var nameUser by remember { mutableStateOf("") }
    var reapeatPassword by remember { mutableStateOf("") }

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
            onValueChange = { nameUser = it },
            label = { Text("Name User") },
            modifier = Modifier.width(300.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF5E5CE6),
                unfocusedTextColor = Color(0xFF5E5CE6)
            )
        )

        Box(modifier = Modifier.height(16.dp))

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

        Box(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = reapeatPassword,
            onValueChange = { reapeatPassword = it },
            label = { Text("Repeat Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.width(300.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF5E5CE6),
                unfocusedTextColor = Color(0xFF5E5CE6)
            )
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

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(55.dp)
                .clip(RoundedCornerShape(50.dp))
                .border(1.dp, Color(0xFF5E5CE6), RoundedCornerShape(50.dp)),
            contentAlignment = Alignment.Center
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


