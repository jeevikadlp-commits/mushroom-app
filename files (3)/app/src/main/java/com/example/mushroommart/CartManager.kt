package com.example.mushroommart

object CartManager {
    val cart = mutableListOf<Product>()
    fun addToCart(p: Product) { cart.add(p) }
    fun clearCart() { cart.clear() }
}