package com.mortiz.products_register.model.entities

sealed class Product {
    data class NewProduct(
        val id: Long,
        val name: String,
        val price: Double
    ) : Product()

    object EmptyProduct : Product()

}