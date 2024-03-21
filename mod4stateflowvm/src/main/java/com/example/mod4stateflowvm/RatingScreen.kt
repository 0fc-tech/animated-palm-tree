package com.example.mod4stateflowvm

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RatingScreen(vm : RatingViewModel = viewModel()) {
    val state by vm.ratingState.collectAsState()
    var stateFeedback by remember { mutableStateOf("") }

    Column {
        Slider(
            value=state.note.toFloat(),
            steps = 10,
            valueRange = 0f..10f,
            onValueChange = {
                vm.updateRating(it.toInt())
            }
        )
        if(state is RatingState.RequestFeedback){
            Text(text =
            "Qu'est-ce qu'on pourrait faire de mieux la prochaine fois ?"
            )
            TextField(value = stateFeedback,
                onValueChange = {stateFeedback = it})
        }

    }
}



