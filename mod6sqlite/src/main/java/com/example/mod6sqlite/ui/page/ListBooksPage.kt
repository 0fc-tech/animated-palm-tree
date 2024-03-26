package com.example.mod6sqlite.ui.page

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6sqlite.vm.ListBooksViewModel


@Composable
fun ListBooks(vm : ListBooksViewModel = viewModel(
    factory= ListBooksViewModel.Factory),
    onAddClick : ()->Unit
) {
    Scaffold(
        floatingActionButton = { FloatingActionButton(
            onClick = { onAddClick() }) {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = "ajouter Livre")
        }}
    ) {innerPadding->
        Text(vm.books.value.toString(),Modifier.padding(innerPadding))
    }


}









