package com.example.mod3lazycolumn

import androidx.compose.foundation.lazy.items
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChargingStation
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mod3lazycolumn.ui.theme.DemonstrationsTheme
import kotlin.random.Random

private const val TAG = "MainActivity"
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
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val list200Ele = List(999){ Random.nextBoolean()}
    LazyColumn {
        items(list200Ele){
            Card(onClick ={
                    Log.i(TAG, "Greeting: HELLO CLICK ")
                }, Modifier.padding(16.dp)
                           .fillMaxWidth(),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.ChargingStation, contentDescription = null)
                    Text(it.toString(), Modifier.padding(16.dp))
                }
                Log.i(TAG, "Greeting:$it ")
            }
        }
    }
}

//@Composable
//fun MyCustomCard(modifier: Modifier, content : @Composable () -> Unit ) {
//    Box(modifier = modifier.background(Color.Blue)){
//        content()
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemonstrationsTheme {
        Greeting("Android")
    }
}