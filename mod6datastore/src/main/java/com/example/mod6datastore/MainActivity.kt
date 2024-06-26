package com.example.mod6datastore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6datastore.SettingsViewModel.Companion.Factory
import com.example.mod6datastore.ui.theme.DemonstrationsTheme

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
                    SettingsPage()
                }
            }
        }
    }
}

@Composable
fun SettingsPage(vm : SettingsViewModel = viewModel(factory = Factory)){
    val primColorDataStore by vm.primaryColorStateFlow.collectAsState()
    var primColorUi by remember { mutableStateOf( primColorDataStore ?: "") }
    primColorUi = primColorDataStore ?:""

    Scaffold {innerPadding->
        Column(Modifier.padding(innerPadding)) {
            TextField(
                value = primColorUi,
                onValueChange = { primColorUi = it },
                trailingIcon = {
                    IconButton(onClick = {
                        vm.savePrimaryColor(primColorUi) }) {
                        Image(
                            imageVector=Icons.Default.Check,
                            contentDescription=null
                        )
                    }
                })

            TextField(value = "", onValueChange ={} )
            Text("La couleur primaire est $primColorDataStore")
        }
    }

}