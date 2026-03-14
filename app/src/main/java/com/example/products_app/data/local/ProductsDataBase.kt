package com.example.products_app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.products_app.data.model.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductsDataBase : RoomDatabase(){

    abstract fun getProductsDao(): ProductsDao

    companion object{
        @Volatile
        private var instance: ProductsDataBase? = null
        fun getInstance(context: Context): ProductsDataBase {
            return instance ?: synchronized(this){
                val INSTANCE = Room.databaseBuilder(context, ProductsDataBase::class.java, "roomdb").build()
                instance = INSTANCE
                INSTANCE
            }
        }
    }

}