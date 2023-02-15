package com.example.fakestore.common.remoteDatabase

import com.example.fakestore.common.entities.ProductEntity
import com.example.fakestore.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDatabase {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(FakeStoreServices::class.java)

    suspend fun getAllProducts():MutableList<ProductEntity> = withContext(Dispatchers.IO){
        service.getAllProducts()
    }





}