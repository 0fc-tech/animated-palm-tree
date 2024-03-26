package com.example.mod6sqlite.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod6sqlite.Book
import com.example.mod6sqlite.BookDao
import com.example.mod6sqlite.BookDbHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddBookViewModel(val bookDao : BookDao) : ViewModel() {
    fun insertBook(book : Book){
        viewModelScope.launch(Dispatchers.IO) {
            bookDao.insertBook(book)
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = object :
            ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return AddBookViewModel(
                    BookDao(
                        BookDbHelper(application.applicationContext).writableDatabase
                    ),
                ) as T
            }
        }
    }
}