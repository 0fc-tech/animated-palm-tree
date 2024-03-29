package com.example.mod7retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod7retrofit.ui.theme.DemonstrationsTheme

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
                    WeatherScreen()
                }
            }
        }
    }

    @Composable
    fun WeatherScreen(vm : WeatherViewModel = viewModel()) {
        val weatherState by vm.weatherState.collectAsState()
        LazyColumn {
            weatherState?.let { hourlyData ->
                itemsIndexed(hourlyData.time){indexTime, valueTime ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(valueTime)
                        Text("${hourlyData.temperature_2m[indexTime]}°C")
                    }
                }
            }
        }
    }
}

