package com.example.products_app.all

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.products_app.ProductRow
import com.example.products_app.R

@Composable
fun AllProductsScreen(viewModel: AllProductsViewModel) {
    viewModel.getProducts()
    val dataState = viewModel.products.observeAsState()
    val messageState = viewModel.message.observeAsState()
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {SnackbarHost(snackBarHostState)}
    ) { padding ->
        Log.i("TAG", "AllProductsScreen: $padding ")
        if (dataState.value != null){
            LazyColumn {
                item{
                    Text(text = "Products", textAlign = TextAlign.Center, fontSize = 20.sp, modifier = Modifier.fillMaxWidth().padding(5.dp))
                }
                items(dataState.value?.size ?: 0){ currentIndex ->
                    ProductRow(dataState.value?.get(currentIndex), R.drawable.baseline_add_24, { viewModel.addProduct(it)})
                }
            }
        }else{
            Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                CircularProgressIndicator()
            }
        }
        LaunchedEffect(messageState.value) {
            if(!messageState.value.isNullOrBlank())
                snackBarHostState.showSnackbar(messageState.value!!, duration = SnackbarDuration.Short)
        }
    }
}
