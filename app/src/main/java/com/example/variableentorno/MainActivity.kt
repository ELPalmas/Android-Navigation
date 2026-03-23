package com.example.variableentorno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.variableentorno.ui.theme.VariableEntornoTheme
import androidx.navigation.compose.rememberNavController

import androidx.navigation.compose.*
import com.example.variableentorno.screens.Login
import com.example.variableentorno.screens.MainBody
import com.example.variableentorno.screens.Register

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VariableEntornoTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {

                    composable("home") {
                        MainBody(navController)
                    }

                    composable("login") {
                        Login(navController)
                    }

                    composable("register") {
                        Register(navController)
                    }

                }

            }
        }
    }
}


