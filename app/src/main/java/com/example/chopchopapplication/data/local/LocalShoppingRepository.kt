package com.example.chopchopapplication.data.local

import androidx.lifecycle.LiveData
import com.example.chopchopapplication.data.ShoppingRepository
import javax.inject.Inject

class LocalShoppingRepository @Inject constructor(private val appDatabase: AppDatabase) : ShoppingRepository {
    override fun getAllShoppingList(): LiveData<List<ShoppingItem>> {
        return appDatabase.shoppingDao().getAllShoppingList()
    }

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        appDatabase.shoppingDao().insertShoppingItem(shoppingItem)
    }

    override fun getShoppingListTotalAmount(): LiveData<Float> {
        return appDatabase.shoppingDao().getShoppingListTotalAmount()
    }
}