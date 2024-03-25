package com.example.mod5nav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mod5nav.ui.theme.Typography

@Composable
//onClickToHome est une fonction qui ne renvoie rien (void / Unit)
fun SignInPage(onClickToHome : () -> Unit) {
    Scaffold(contentWindowInsets = WindowInsets(32,32,23,32)) { padding->
        Column(Modifier.padding(padding), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Connectez-vous",
                style = Typography.titleLarge)
            Spacer(Modifier.height(8.dp))
            TextField("Steve Travail",{},Modifier.fillMaxWidth())
            TextField("••••••••••" ,{},Modifier.fillMaxWidth())
            Spacer(Modifier.weight(1f))
            FilledTonalButton(onClick = { onClickToHome() },
                Modifier.fillMaxWidth()) {
                Text("Je veux continuer à payer")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text("Se désabonner")
            }
        }
    }
}