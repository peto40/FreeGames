package com.example.freegames.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.freegames.domain.model.Game
import com.example.freegames.ui.viewmodel.Resource

@Composable
fun DrawbackScreen(
    modifier: Modifier = Modifier,
    pcGameState: Resource<List<Game>>,
    browserGameState: Resource<List<Game>>,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyColumn {
            item {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Games",
                    color = Color.Red
                )
            }
            if (pcGameState is Resource.Error) {
                browserGameState.data?.size?.let { size ->
                    items(size) { game ->
                        Text(text = browserGameState.data[game].title)
                    }
                }
            } else {
                pcGameState.data?.size?.let { size ->
                    items(size) { game ->
                        Text(text = pcGameState.data[game].title)
                    }
                }
            }
        }
    }
}