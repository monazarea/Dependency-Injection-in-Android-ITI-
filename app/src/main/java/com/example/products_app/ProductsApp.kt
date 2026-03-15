package com.example.products_app

import android.app.Application
import com.example.products_app.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ProductsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ProductsApp)
            modules(dataModule)
        }
    }
}