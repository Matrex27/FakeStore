package com.example.fakestore.common.entities

data class ProductEntity(var id: Long,
                         var title: String,
                         var description: String,
                         var price: Long,
                         var images: Array<String>
                   )