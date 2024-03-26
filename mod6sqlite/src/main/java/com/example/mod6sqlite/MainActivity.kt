package com.example.mod6sqlite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mod6sqlite.ui.page.AddBookPage
import com.example.mod6sqlite.ui.page.ListBooks
import com.example.mod6sqlite.ui.theme.DemonstrationsTheme


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
                    NavHostBooks()
                }
            }
        }
    }
}
@Composable
fun NavHostBooks(navController:NavHostController = rememberNavController()) {
    NavHost(
        navController=navController,
        startDestination = "list"){
        composable("list"){
            ListBooks(onAddClick = {
                navController.navigate("add")
            })
        }
        composable("add"){
            AddBookPage()
        }
    }
}





