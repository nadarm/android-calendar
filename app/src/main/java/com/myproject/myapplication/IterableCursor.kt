package com.myproject.myapplication

import android.database.Cursor

class IterableCursor(private val cursor: Cursor) : Iterable<Cursor> {

    init {
        cursor.moveToPosition(-1)
    }

    override fun iterator(): Iterator<Cursor> {
        return object : Iterator<Cursor> {
            override fun hasNext(): Boolean {
                return !cursor.isClosed && cursor.moveToNext()
            }

            override fun next(): Cursor {
                return cursor
            }
        }
    }

}