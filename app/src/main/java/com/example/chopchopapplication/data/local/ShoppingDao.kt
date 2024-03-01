package com.example.chopchopapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShoppingDao {

    @Query("select * from SHOPPING_TABLE")
    fun getAllShoppingList(): LiveData<List<ShoppingItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    @Query("select SUM(price * count) from shopping_table")
    fun getShoppingListTotalAmount(): LiveData<Float>
}