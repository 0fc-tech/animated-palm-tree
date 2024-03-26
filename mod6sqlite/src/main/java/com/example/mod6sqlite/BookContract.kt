package com.example.mod6sqlite

import android.provider.BaseColumns

object BookContract {
    const val TABLE_NAME = "books"
    const val COLUMN_NAME = "name"
    const val COLUMN_ISBN = "isbn"
    const val COLUMN_RELEASE_DATE = "release_date"
    const val COLUMN_EDITOR = "editor"
    const val COLUMN_AUTHOR = "author"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "BookStore.db"
    const val SQL_CREATE_ENTRIES =
        """ CREATE TABLE $TABLE_NAME (
             ${BaseColumns._ID} INTEGER PRIMARY KEY,
             $COLUMN_NAME TEXT, $COLUMN_ISBN TEXT,
             $COLUMN_RELEASE_DATE TEXT,
             $COLUMN_EDITOR TEXT,
             $COLUMN_AUTHOR TEXT
        )"""
    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"


}