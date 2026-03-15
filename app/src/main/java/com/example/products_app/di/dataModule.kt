package com.example.products_app.di

import androidx.appcompat.widget.AppCompatDrawableManager.get
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.di_starterapplication.data.repository.ProductsRepository
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.all.AllProductsViewModel
import com.example.products_app.data.local.LocalDataSource
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductService
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RemoteDataSource
import com.example.products_app.fav.FavProductsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl( "https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single <ProductsDataBase>{
        Room.databaseBuilder(
            androidContext(),
            ProductsDataBase::class.java,
            "roomdb").build()
    }
    single {
        val retrofit: Retrofit = get()
        retrofit.create(ProductService::class.java)

    }
    single{
        val db: ProductsDataBase = get()
        db.getProductsDao()
    }
    factory<RemoteDataSource> {
        ProductsRemoteDataSourceImpl(get())
    }

    factory < LocalDataSource>{
        ProductsLocalDataSource(get())
    }
    single<ProductsRepository> { ProductsRepositoryImpl(get(), get()) }

    viewModel<AllProductsViewModel> { AllProductsViewModel(get())  }
    viewModel<FavProductsViewModel> { FavProductsViewModel(get())  }
}