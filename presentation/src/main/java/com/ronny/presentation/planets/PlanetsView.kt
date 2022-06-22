package com.ronny.presentation.planets

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PlanetsView() {

    Scaffold {
        Text(
            text = "Planets",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )

    }

}


@Preview
@Composable
fun PlanetsPreview() = PlanetsView()