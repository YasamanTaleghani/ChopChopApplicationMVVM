package com.example.chopchopapplication.data

import androidx.lifecycle.LiveData
import com.example.chopchopapplication.data.local.ShoppingItem

interface ShoppingRepository {
    fun getAllShoppingList(): LiveData<List<ShoppingItem>>
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)
    fun getShoppingListTotalAmount(): LiveData<Float>
}