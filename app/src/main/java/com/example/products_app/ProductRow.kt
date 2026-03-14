package com.example.products_app

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.products_app.data.model.Product

@OptIn(ExperimentalGlideComposeApi::class)
@Preview(showBackground = true)
@Composable
fun ProductRow(product: Product? = null, actionIcon : Int = R.drawable.baseline_remove_24, onClick: (Product?) -> Unit ={}) {
    Row (modifier = Modifier.fillMaxWidth().padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        GlideImage(model = product?.thumbnail, contentDescription = product?.description,  contentScale= ContentScale.Crop, modifier = Modifier.size(100.dp).fillMaxWidth(0.3f).clip(
            CircleShape).border(BorderStroke(2.dp, Color.Black) ,CircleShape))
        Column (modifier = Modifier.fillMaxWidth(0.3f)){
            Text(text = product?.title ?: "Title" , fontFamily = FontFamily.Monospace, fontSize = 15.sp)
            Text(text = product?.price.toString() ?: "N/A", fontFamily = FontFamily.Monospace, fontSize = 15.sp, maxLines = 1)
        }
        Button(onClick = { onClick(product) }, modifier = Modifier.fillMaxWidth(0.4f)) {
            Icon(painter =  painterResource(actionIcon), contentDescription = null)
        }
    }
}

