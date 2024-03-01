package com.example.chopchopapplication.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.chopchopapplication.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ShoppingDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var shoppingDao: ShoppingDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        shoppingDao = database.shoppingDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertShoppingItem() = runBlocking {
        val shoppingItem = ShoppingItem("banana", 0.5f, 10, 1)
        shoppingDao.insertShoppingItem(shoppingItem)

        val allShoppingList = shoppingDao.getAllShoppingList().getOrAwaitValue()
        assertThat(allShoppingList).contains(shoppingItem)
    }

    @Test
    fun getShoppingItemTotalAmount() = runBlocking {
        val shoppingItem = ShoppingItem("banana", 0.5f, 10, 1)
        shoppingDao.insertShoppingItem(shoppingItem)

        val totalItems = shoppingDao.getShoppingListTotalAmount().getOrAwaitValue()
        assertThat(totalItems).isEqualTo(5.0f)
    }
}