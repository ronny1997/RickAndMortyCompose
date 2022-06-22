package com.ronny.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ronny.presentation.authentication.LoginViewModel
import com.ronny.presentation.home.componets.AppBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeView(
    viewModel: HomeViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = { AppBar() }
    ) {
        val list = getItems()

        LazyVerticalGrid(
            cells = GridCells.Adaptive(100.dp),
            contentPadding = PaddingValues(4.dp)
        ) {
            items(list.size) { item ->
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(1.dp)
                ) {
                    Text(text = list[item])
                }
            }
        }

    }

}



fun getItems(): List<String> =
    listOf(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )

@Preview
@Composable
fun HomeViewPreview() = HomeView()