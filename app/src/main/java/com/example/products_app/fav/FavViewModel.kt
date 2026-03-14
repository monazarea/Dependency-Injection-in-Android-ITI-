package com.example.products_app.fav

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.products_app.data.model.Product
import com.example.di_starterapplication.data.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavProductsViewModel (private val repository: ProductsRepository): ViewModel() {
    private val mutableMessage : MutableLiveData<String?> = MutableLiveData()
    val message : LiveData<String?> = mutableMessage

    private val mutableProducts : MutableLiveData<List<Product>?> = MutableLiveData(null)
    val products : LiveData<List<Product>?> = mutableProducts

    init {
        Log.i("TAG", "ViewModel: Initializer")
    }

    fun getProducts(){
        viewModelScope.launch (Dispatchers.IO){
            try {
                val list = repository.getAllProducts(false)
                if(list!=null){
                    mutableProducts.postValue(list)
                }else{
                    mutableMessage.postValue("Couldn't Load Data")
                }
            }catch (ex: Exception){
                mutableMessage.postValue(ex.message)
            }
        }
    }



    fun removeProduct(product: Product?){
        if(product != null){
            viewModelScope.launch {
                try {
                    repository.removeProduct(product)
                    getProducts()
                    mutableMessage.postValue("${product.title} is removed from favorite")
                }catch (ex:Exception){
                    mutableMessage.postValue(ex.message)
                }
            }
        }else{
            mutableMessage.postValue("Couldn't be removed from Favorites")
        }
    }
}

class FavProductFactory(private val repository: ProductsRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavProductsViewModel(repository) as T
    }
}