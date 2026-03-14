package com.example.products_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class Product (
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val brand: String,
    val thumbnail: String
)
