package com.example.pizzeriapp.Database

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface GoodItemsRepository {

    suspend fun insert(item : GoodItem)

    suspend fun update(item : GoodItem)

    suspend fun  delete(id: Int)

    fun getAllItems() : Flow<List<GoodItem>>

    fun countByTitle(title: String): Int

    suspend fun deleteItemsWithDuplicateDescriptions()

}