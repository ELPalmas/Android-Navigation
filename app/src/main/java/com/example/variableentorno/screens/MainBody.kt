package com.example.variableentorno.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.variableentorno.R



@Composable
fun MainBody(navController: NavController) {

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
                .background(Color(0xFF5E5CE6))
                .clickable {
                    navController.navigate("login")
                },

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
                .border(1.dp, Color(0xFF5E5CE6), RoundedCornerShape(50.dp))
                .clickable {
                    navController.navigate("register")
                },
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

