package com.example.chopchopapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class ShoppingItem(
    var name: String,
    var price: Float,
    var count: Int
) {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}
