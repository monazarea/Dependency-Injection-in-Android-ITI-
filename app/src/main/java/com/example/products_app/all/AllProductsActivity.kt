package com.example.products_app.all

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.lifecycle.ViewModelProvider
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RetrofitHelper

class AllProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel = ViewModelProvider(this, AllProductFactory(ProductsRepositoryImpl.getInstance(
                ProductsRemoteDataSourceImpl(RetrofitHelper.service),
                ProductsLocalDataSource(ProductsDataBase.getInstance(this@AllProductsActivity).getProductsDao())
            )))[AllProductsViewModel::class.java]

            AllProductsScreen(viewModel)
        }
    }
}
