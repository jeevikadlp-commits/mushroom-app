package com.example.mushroommart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        tvCartItems.text = CartManager.cart.map { it.name }.joinToString("\n")
        // TODO: Add payment, place order logic
    }
}