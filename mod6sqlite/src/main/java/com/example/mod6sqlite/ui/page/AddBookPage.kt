package com.example.mod6sqlite.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6sqlite.Book
import com.example.mod6sqlite.vm.AddBookViewModel

@Composable
fun AddBookPage(vm: AddBookViewModel = viewModel(factory = AddBookViewModel.Factory)) {
    var stateName by remember {mutableStateOf("")}
    var stateIsbn by remember {mutableStateOf("")}
    var stateRelease by remember {mutableStateOf("")}
    var stateEditor by remember {mutableStateOf("")}
    var stateAuthor by remember {mutableStateOf("")}

    Scaffold {innerPadding->
        Column(Modifier.padding(innerPadding)){
            TextField(value = stateName,
                    onValueChange = {stateName = it},
                    label = {Text("Name")})
            TextField(value = stateIsbn,
                    onValueChange = {stateIsbn = it},
                    label = {Text("ISBN")})
            TextField(value = stateRelease,
                    onValueChange = {stateRelease = it},
                    label = {Text("Release")})
            TextField(value = stateEditor,
                    onValueChange = {stateEditor = it},
                    label = {Text("Editor")})
            TextField(value = stateAuthor,
                    onValueChange = {stateAuthor = it},
                    label = {Text("Author")})
            FilledTonalButton(
                onClick = {
                    vm.insertBook(
                        Book(0L,stateName,stateIsbn,stateRelease,stateEditor,stateAuthor))

                }) {
                Text("AJOUTER")
            }
        }
    }
}








