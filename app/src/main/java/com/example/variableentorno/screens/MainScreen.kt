package com.example.variableentorno.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.variableentorno.components.Contact

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    /* lista vieja estatica
    val contacts = listOf(
        Pair(first = "Juan Pérez", second = "612-123-4567"),
        Pair(first = "Ana López", second = "612-525-4125")
    )*/

    // Lista en un estado
    val contactList = remember { mutableStateListOf<Pair<String, String>>() }

    var nameError by remember { mutableStateOf(false) }
    fun isValidName(name: String): Boolean {
        return name.matches(Regex("^[a-zA-Z ]+$"))
    }

    var phoneError by remember { mutableStateOf(false) }
    fun isValidPhone(phone: String): Boolean {
        return phone.matches(Regex("^\\d{10}$"))
    }

    fun agregarContacto(name:String, phone:String){
        //agregar elementos
        contactList.add(Pair(first = name, second = phone))
    }

    fun limpiarCampos(){
        name = ""
        phone = ""
    }

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
            text = "Mis contactos",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Box(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
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
            value = phone,
            onValueChange = {
                phone = it
                phoneError = !isValidPhone(phone = it)
            },
            label = { Text("telefono") },
            isError = phoneError,
            modifier = Modifier.width(300.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xFF5E5CE6),
                unfocusedTextColor = Color(0xFF5E5CE6)
            )
        )

        Box(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                agregarContacto(name, phone)
                limpiarCampos()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5E5CE6)
            )
        ) {
            Text(
                text = "Agregar Contacto",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Box(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = { limpiarCampos() },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            border = BorderStroke(1.dp, Color(0xFF5E5CE6)),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(
                text = "Limpiar campos",
                color = Color(0xFF5E5CE6),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(modifier = Modifier.height(16.dp))

        // Empieza la lista
        LazyColumn(
            modifier = Modifier.weight(1f)
        )  {
            items(items = contactList) { contact ->
                Contact(name = contact.first, phone = contact.second)


            }
        }
    }

}

@Preview
@Composable
fun MainScreenPreview(){
    val navController = rememberNavController()
    MainScreen(navController)
}