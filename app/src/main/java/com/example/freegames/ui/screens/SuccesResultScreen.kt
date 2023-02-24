package com.example.freegames.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freegames.domain.model.Game
import com.example.freegames.ui.viewmodel.Resource

@Composable
fun SuccessResultScreen(
    modifier: Modifier = Modifier,
    pcGameState: Resource<List<Game>>,
    browserGameState: Resource<List<Game>>,
) {

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .align(CenterHorizontally),
            text = "Result is success",
            fontSize = 24.sp,
        )

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            LazyColumn{
                item {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Pc shooters",
                        color = Color.Red
                    )
                }
                pcGameState.data?.size?.let {
                    items(count = it) {item ->
                        Text(text = pcGameState.data[item].title)
                    }
                }
            }
            LazyColumn{
                item {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Browser rpg",
                        color = Color.Red
                    )
                }
                browserGameState.data?.size?.let {
                    items(count = it) {game ->
                        Text(text = browserGameState.data[game].title)
                    }
                }
            }
        }

    }

}