package com.example.products_app.data.remote

import com.example.products_app.data.remote.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductService{
    @GET("products")
    suspend fun getAllProducts(): Response<ProductResponse>
}