package com.example.chopchopapplication.data.di

import android.content.Context
import androidx.room.Room
import com.example.chopchopapplication.data.local.AppDatabase
import com.example.chopchopapplication.data.local.ShoppingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideMyModelDao(appDatabase: AppDatabase): ShoppingDao {
        return appDatabase.shoppingDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return  Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "ShoppingListModel"
        ).build()
    }
}