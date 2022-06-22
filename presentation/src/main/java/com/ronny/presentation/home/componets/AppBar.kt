package com.ronny.presentation.home.componets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppBar() {
    val (email, setTextEmail) = remember { mutableStateOf("") }
    TextField(
        value = email,
        onValueChange = setTextEmail,
        maxLines = 1,
        label = { Text("Search") },
        placeholder = { Text("Search") },
        modifier = Modifier
            .padding(horizontal = 26.dp)
            .padding(bottom = 5.dp, top = 5.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun AppBarPreview() = AppBar()