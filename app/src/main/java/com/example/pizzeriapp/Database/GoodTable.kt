package com.example.pizzeriapp.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GoodTable")
data class GoodItem (
    @PrimaryKey
    val id : Int ?= null,
    val image : Int,
    val title : String,
    val price : Int,
    val weight : Int,
    val description : String,
    val quantity : Int,
    val isNew : Boolean

)