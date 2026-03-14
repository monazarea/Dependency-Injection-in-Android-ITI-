package com.example.products_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.products_app.all.AllProductsActivity
import com.example.products_app.all.AllProductsScreen
import com.example.products_app.fav.FavProductsActivity
import com.example.products_app.fav.FavProductsScreen
import com.example.products_app.ui.theme.ProductsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {startActivity(Intent(this@MainActivity, AllProductsActivity::class.java)) }) {
                    Text(text = "All Products")
                }
                Button(onClick = {startActivity(Intent(this@MainActivity, FavProductsActivity::class.java)) }) {
                    Text(text = "Favorite Products")
                }
                Button(onClick = {finish()}) {
                    Text(text = "Exit")
                }
            }
        }
    }
}

