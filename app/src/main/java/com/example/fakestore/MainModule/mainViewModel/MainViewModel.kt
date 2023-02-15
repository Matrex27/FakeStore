package com.example.fakestore.MainModule.mainViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.MainModule.mainInteractor.MainInteractor
import com.example.fakestore.common.entities.ProductEntity
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel: ViewModel() {

    private val interactor = MainInteractor()

    private var result = MutableLiveData<MutableList<ProductEntity>>()

    fun getResult():LiveData<MutableList<ProductEntity>>{
        return result
    }

    fun getAllProducts(){
        viewModelScope.launch {
            try {
                var resultServer = interactor.getAllProducts()
                result.value = resultServer


            }catch (e: HttpException){
                (e as? HttpException)?.let {
                    when(it.code()){
                        400 -> Log.i("Error: ", "Error 400 Bad Request")

                        else -> Log.i("Error: ", "Error desconocido")
                    }
                }
            }
        }
    }



}