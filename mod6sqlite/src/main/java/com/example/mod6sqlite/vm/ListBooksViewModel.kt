package com.example.mod6sqlite.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod6sqlite.Book
import com.example.mod6sqlite.BookDao
import com.example.mod6sqlite.BookDbHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListBooksViewModel(private val _dao: BookDao) :
    ViewModel() {
    private val _books = mutableStateOf<List<Book>>(emptyList())
    val books: State<List<Book>> = _books
    init {
        viewModelScope.launch {
            insertBook(
                Book(
                0L,"Harry Potter and the Philosopher's Stone","9781408855652","19/08/2014",
                "Bloomsburry",
                "J.K. Rowling"
            )
            )
            insertBook(
                Book(
                0L,"Harry Potter and the Chamber of Secrets","1408855666","19/08/2014",
                "Bloomsburry",
                "J.K. Rowling"
            )
            )
            loadBooks()
        }
    }
    private suspend fun loadBooks() {
        withContext(Dispatchers.IO) {
            val booksFromDb = _dao.getAllBooks()
            _books.value = booksFromDb
        }
    }
    suspend fun insertBook(book : Book){
        withContext(Dispatchers.IO) {
            val resultBook = _dao.insertBook(book)
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
                val application = checkNotNull(extras[APPLICATION_KEY])
                return ListBooksViewModel(
                    BookDao(
                        BookDbHelper(application.applicationContext).writableDatabase
                    ),
                ) as T
            }
        }
    }
}
