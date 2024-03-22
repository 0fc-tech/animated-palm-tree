package com.example.mod5activites

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.mod5activites.ui.theme.DemonstrationsTheme

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
                    Scaffold {padding->
                        Column (Modifier.padding(padding)){
                            ButtonTarget()
                            ButtonViewENI()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ButtonViewENI() {
        OutlinedButton(onClick = {
            val intentViewENI = Intent(
                ACTION_VIEW,
                Uri.parse("geo:47.2266131,-1.6202917")
            )
            startActivity(intentViewENI)
        }) {
            Text("Voir ENI")
        }
    }

    @Composable
    fun ButtonTarget(modifier: Modifier = Modifier) {
        val context = LocalContext.current
        OutlinedButton(modifier = modifier,onClick = {
            val intentTarget = Intent(
                context,
                TargetActivity::class.java
            )
            startActivity(intentTarget)
        }) {
            Text("Allez vers TargetActivity")
        }
    }
}
