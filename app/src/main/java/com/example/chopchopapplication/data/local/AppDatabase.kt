package com.example.chopchopapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ShoppingItem::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun shoppingDao(): ShoppingDao
}