package com.mortiz.products_register.model.repository
import com.mortiz.products_register.model.entities.Product

class InMemoryProductRepository : ProductRepository {
    private val products = mutableListOf<Product>()

    override fun addProduct(product: Product) {
        products.add(product)
    }

    override fun findById(id: Long): Product? {
        return products.find { it is Product.NewProduct && it.id == id }
            ?: Product.EmptyProduct
    }

    override fun getAllProducts(): List<Product> {
        return products
    }

}
