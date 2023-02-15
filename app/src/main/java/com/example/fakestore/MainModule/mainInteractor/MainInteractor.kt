package com.example.fakestore.MainModule.mainInteractor

import com.example.fakestore.common.entities.ProductEntity
import com.example.fakestore.common.remoteDatabase.RemoteDatabase

class MainInteractor {

    private val remoteDatabase = RemoteDatabase()

    suspend fun getAllProducts(): MutableList<ProductEntity> =
        remoteDatabase.getAllProducts()





}