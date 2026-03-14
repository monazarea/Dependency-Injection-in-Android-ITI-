package com.example.products_app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.products_app.data.model.Product

@Dao
interface ProductsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: Product): Long

    @Delete
    suspend fun deleteProduct(product: Product): Int

    @Query("Select * from products_table")
    suspend fun getAllFavoriteProducts(): List<Product>
}