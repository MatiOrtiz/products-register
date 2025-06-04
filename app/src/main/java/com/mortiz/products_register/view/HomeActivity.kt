package com.mortiz.products_register.view

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.mortiz.products_register.R
import com.mortiz.products_register.controller.main

class HomeActivity : Activity() {

    private lateinit var productName: EditText
    private lateinit var productID: EditText
    private lateinit var productPrice: EditText
    private lateinit var productIDForSearch: EditText

    private lateinit var addProductButton: Button
    private lateinit var searchProductButton: Button
    private lateinit var showProductsButton: Button

    // Injector
    private val injector = main()
    private val controller = injector.controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initProperties()
        initListeners()
    }

    private fun initProperties() {
        productName = findViewById(R.id.nameProductInputText)
        productID = findViewById(R.id.IDProductInputText)
        productIDForSearch = findViewById(R.id.IDProductForSearchInputText)
        productPrice = findViewById(R.id.priceProductInputText)

        addProductButton = findViewById(R.id.addProductButton)
        searchProductButton = findViewById(R.id.searchProductButton)
        showProductsButton = findViewById(R.id.getAllProductsButton)
    }

    private fun initListeners() {
        addProductButton.setOnClickListener {
            val name = productName.text.toString()
            val id = productID.text.toString().toLongOrNull()
            val price = productPrice.text.toString().toDoubleOrNull()
            if (name.isNotBlank() && id != null && price != null) {
                controller.addProduct(id, name, price)
                Toast.makeText(this, "Product added: $name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }

        searchProductButton.setOnClickListener {
            val id = productIDForSearch.text.toString().toLongOrNull()
            if (id != null) {
                val product = controller.findProductByID(id)
                showDialog("Product found", product?.toString() ?: "No product with that ID")
            } else {
                Toast.makeText(this, "Invalid ID", Toast.LENGTH_SHORT).show()
            }
        }

        showProductsButton.setOnClickListener {
            val products = controller.getAllProducts()
            showDialog("All products", products.toString())
        }
    }

    private fun showDialog(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Dismiss", null)
            .show()
    }
}