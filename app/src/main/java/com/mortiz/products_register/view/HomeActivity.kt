package com.mortiz.products_register.view

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.mortiz.products_register.R

class HomeActivity : Activity(){

    private lateinit var descriptionTextView: TextView

    private lateinit var productName: EditText
    private lateinit var productID: EditText
    private lateinit var productPrice: EditText

    private lateinit var addProductButton: Button
    private lateinit var searchProductButton: Button
    private lateinit var showProductsButton: Button



    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initProperties()

    }

    private fun initProperties(){
        descriptionTextView = findViewById(R.id.ProductsItinerary)

        productName = findViewById(R.id.nameProductInputText)
        productID = findViewById(R.id.IDProductInputText)
        productID = findViewById(R.id.IDProductForSearchInputText)
        productPrice = findViewById(R.id.priceProductInputText)

        addProductButton = findViewById(R.id.addProductButton)
        searchProductButton = findViewById(R.id.searchProductButton)
        showProductsButton = findViewById(R.id.getAllProductsButton)
    }

}