package com.example.fakestore.common.remoteDatabase

import com.example.fakestore.common.entities.ProductEntity
import com.example.fakestore.common.utils.Constants
import retrofit2.http.GET

interface FakeStoreServices {

    @GET(Constants.PRODUCTS_URL)
    suspend fun getAllProducts(): MutableList<ProductEntity>



}