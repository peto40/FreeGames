package com.example.freegames.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onGetGamesClick: () -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(24.dp),
            text = "Main screen",
            fontSize = 26.sp
        )

        Button(
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 64.dp),
            onClick = { onGetGamesClick() }
        ) {
            Text(text = "Get data from api")
        }
    }
}