package com.example.mushroommart

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val products = mutableListOf<Product>()
    private val adapter = ProductAdapter(products) { product ->
        CartManager.addToCart(product)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerProducts.layoutManager = LinearLayoutManager(this)
        recyclerProducts.adapter = adapter

        btnGoToCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        fetchProducts()
    }

    private fun fetchProducts() {
        FirebaseFirestore.getInstance().collection("products")
            .get()
            .addOnSuccessListener { result ->
                products.clear()
                for (doc in result) {
                    val p = doc.toObject(Product::class.java)
                    products.add(p)
                }
                adapter.notifyDataSetChanged()
            }
    }
}