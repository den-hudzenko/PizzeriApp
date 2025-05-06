package com.example.pizzeriapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GoodItem::class], version = 2, exportSchema = false)
abstract class GoodDatabase : RoomDatabase() {

    abstract fun goodDao() : GoodDao
    companion object{
        @Volatile
        private var Instance : GoodDatabase? = null

        fun getDatabase(context : Context) : GoodDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, GoodDatabase::class.java, "good_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}