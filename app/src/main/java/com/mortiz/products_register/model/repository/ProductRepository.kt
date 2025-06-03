package com.mortiz.products_register.model.repository

import com.mortiz.products_register.model.entities.Product

interface ProductRepository {

    fun addProduct(product: Product)

    fun findById(id: Long): Product?

    fun getAllProducts(): List<Product>

}