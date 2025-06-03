package com.mortiz.products_register.controller

import com.mortiz.products_register.model.entities.Product
import com.mortiz.products_register.model.repository.InMemoryProductRepository
import com.mortiz.products_register.model.repository.ProductRepository

class main {

    private val repository : ProductRepository = InMemoryProductRepository()

    private val addProductUseCase = AddProduct(repository)
    private val findProductByIDUseCase = FindProductByID(repository)
    private val getAllProductsUseCase = GetAllProducts(repository)

    private val controller = HomeController(addProductUseCase, findProductByIDUseCase, getAllProductsUseCase)



    // Agregar producto ejemplo usando el controlador
    val product = controller.addProduct(1L,"Laptop", 1200.00)

    // Consultar un producto por ID
    val productById = controller.findProductByID(1L)
    var text1 = println("Producto con ID 1: $productById")

    // Consultar todos los productos y mostrarlos
    val allProducts = controller.getAllProducts()
    var text2 = println("Todos los productos: $allProducts")

}

class AddProduct(private val repository: ProductRepository) {
    fun execute(product: Product) {
        repository.addProduct(product)
    }
}

class FindProductByID(private val repository: ProductRepository) {
    fun execute(id: Long): Product? {
        return repository.findById(id)
    }
}

class GetAllProducts(private val repository: ProductRepository) {
    fun execute(): List<Product> {
        return repository.getAllProducts()
    }

}