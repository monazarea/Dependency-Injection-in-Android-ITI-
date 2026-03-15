package com.example.products_app.all

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            val viewModel = ViewModelProvider(this, AllProductFactory(ProductsRepositoryImpl.getInstance(
//                ProductsRemoteDataSourceImpl(RetrofitHelper.service),
//                ProductsLocalDataSource(ProductsDataBase.getInstance(this@AllProductsActivity).getProductsDao())
//            )))[AllProductsViewModel::class.java]

           // val viewModel = viewModel<AllProductsViewModel>()
            val viewModel = hiltViewModel<AllProductsViewModel>()
            AllProductsScreen(viewModel)
        }
    }
}
