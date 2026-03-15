package com.example.products_app.fav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
//            val viewModel = ViewModelProvider(this, FavProductFactory(
//                ProductsRepositoryImpl.getInstance(
//                ProductsRemoteDataSourceImpl(RetrofitHelper.service),
//                ProductsLocalDataSource(ProductsDataBase.getInstance(this@FavProductsActivity).getProductsDao())
//            ))
//            )[FavProductsViewModel::class.java]
            val viewModel = hiltViewModel<FavProductsViewModel>()
            FavProductsScreen(viewModel)
        }
    }
}

