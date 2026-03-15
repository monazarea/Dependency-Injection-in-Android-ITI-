package com.example.products_app.di

import android.app.Application
import androidx.room.Room
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.remote.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://dummyjson.com/"
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideProductsService(retrofit: Retrofit): ProductService{
        return retrofit.create(ProductService::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsDataBase(application: Application): ProductsDataBase {
        return Room.databaseBuilder(
            application, ProductsDataBase::class.java,
            "roomdb")
            .build()
    }

    @Provides
    fun provideProductsDao(productsDataBase: ProductsDataBase) = productsDataBase.getProductsDao()

}