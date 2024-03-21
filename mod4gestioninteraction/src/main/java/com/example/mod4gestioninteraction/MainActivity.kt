package com.example.mod4gestioninteraction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DatePicker
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mod4gestioninteraction.ui.theme.DemonstrationsTheme

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
                    //FormulaireUtilisateur()
                    Compteur()
                }
            }
        }
    }
}

@Composable
fun FormulaireUtilisateur() {
    var prenom by rememberSaveable { mutableStateOf("") }
    var nom by rememberSaveable { mutableStateOf("") }
    var dateNaissance by rememberSaveable { mutableStateOf("") }
    Scaffold(contentWindowInsets = WindowInsets(8,8,8,8)) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value=prenom,
                onValueChange = {prenom = it},
                label = {Text("Prénom")},
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value=nom,
                onValueChange = {nom = it},
                label = {Text("Nom")}
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value=dateNaissance,
                onValueChange = {dateNaissance = it},
                label = {Text("Date de naissance")}
            )
        }
    }

}

@Composable
fun Compteur() {
    var compteur by remember { mutableIntStateOf(0) }
    Row{
        IconButton(onClick = {
            compteur+=1
        }) {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = null)
        }
        Text(compteur.toString())
    }
}