package com.example.pizzeriapp.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface GoodDao {

    @Insert
    suspend fun insert(item : GoodItem)

    @Update
    suspend fun update(item : GoodItem)

    @Query("DELETE FROM GoodTable WHERE id = :id")
    suspend fun  delete(id : Int)

    @Query("DELETE FROM GoodTable")
    suspend fun  deleteAll()
    @Query("SELECT DISTINCT id, title, price, weight, image, description, quantity, isNew FROM GoodTable")
    fun getAllItems() : Flow<List<GoodItem>>


    @Query("SELECT COUNT(*) FROM GoodTable WHERE title = :title")
    fun countByTitle(title: String): Int
    @Query("DELETE FROM GoodTable WHERE title IN (SELECT title FROM GoodTable GROUP BY description HAVING COUNT(*) > 1)")
    suspend fun deleteItemsWithDuplicateDescriptions()
}