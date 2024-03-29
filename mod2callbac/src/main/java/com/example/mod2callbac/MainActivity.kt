package com.example.mod2callbac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod2callbac.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //val gouvernement : String? = null
        //val liberte : Boolean = gouvernement?.equals("") ?: false
        //val liberte2 : Boolean = gouvernement!!.equals("") ?: false



        super.onCreate(savedInstanceState)
        setContent {
            DemonstrationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun ListOrdinateurPage() {
    //Naviguer
    Scaffold {innerPadding->
        ListOrdinateur(Modifier.padding(innerPadding), onOrdinateurClick = { ordinateur->
            //Naviguer vers la page d'ordinateur
        })
    }
}
@Composable
fun ListOrdinateur(modifier : Modifier = Modifier,onOrdinateurClick: (Int)->Unit) {
    LazyColumn(modifier) {
        items(listOf(1,2,3,6,4,5,6,78,9,2,25,4)){
            OutlinedButton(onClick = { onOrdinateurClick(it) }) {
                Text("$it")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemonstrationsTheme {
        //Greeting("Android")
    }
}