package com.example.mod6room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6room.ListMusicViewModel.Companion.Factory
import com.example.mod6room.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemonstrationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListMusics()
                }
            }
        }
    }
}
@Composable
fun ListMusics(vm : ListMusicViewModel = viewModel(factory = Factory)) {
    val stateListMusic = vm.stateMusicList.collectAsState()
    vm.fetchMusics()

    Scaffold {innerPadding->
        LazyColumn(Modifier.padding(innerPadding)) {
            items(stateListMusic.value){music->
                Card(Modifier.padding(16.dp)) {
                    Text(music.title,
                        modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}








