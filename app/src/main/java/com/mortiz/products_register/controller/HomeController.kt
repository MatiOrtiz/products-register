package com.mortiz.products_register.controller

import com.mortiz.products_register.model.entities.Product

class HomeController(private val addProductUseCase: AddProduct,
                     private val findProductByIDUseCase: FindProductByID,
                     private val getAllProductsUseCase : GetAllProducts) {

    fun addProduct(id:Long, name:String, price:Double) {
        addProductUseCase.execute(product = Product.NewProduct(id, name, price))
    }

    fun findProductByID(id: Long): Product?{
        return findProductByIDUseCase.execute(id)
    }

    fun getAllProducts(): List<Product>{
        return getAllProductsUseCase.execute()
    }

}