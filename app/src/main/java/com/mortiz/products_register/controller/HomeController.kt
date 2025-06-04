package com.mortiz.products_register.controller

import com.mortiz.products_register.model.entities.Product

class HomeController(
    private val addProductUseCase: AddProduct,
    private val findProductByIDUseCase: FindProductByID,
    private val getAllProductsUseCase: GetAllProducts
) {

    fun addProduct(id: Long?, name: String?, price: Double?): Boolean {
        // Validación de negocio centralizada aquí
        if (id == null || name.isNullOrBlank() || price == null || price <= 0.0) {
            return false
        }

        addProductUseCase.execute(Product.NewProduct(id, name, price))
        return true
    }

    fun findProductByID(id: Long?): Product? {
        if (id == null) return null
        return findProductByIDUseCase.execute(id)
    }

    fun getAllProducts(): List<Product> {
        return getAllProductsUseCase.execute()
    }
}
