package com.example.products_app.di

import androidx.annotation.RequiresPermission
import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultDispatcher


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainDispatcher