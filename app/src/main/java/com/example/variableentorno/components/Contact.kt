package com.example.variableentorno.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.variableentorno.R

@Composable
fun Contact(name: String, phone: String) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.contacts),
            contentDescription = "Foto de contacto",
            modifier = Modifier.size(size = 64.dp)
        )
        Spacer(modifier = Modifier.width(width = 12.dp))
        Column {
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = phone,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ContactPreview() {
    Contact(name = "Angel Ojeda", phone = "6121234567")
}