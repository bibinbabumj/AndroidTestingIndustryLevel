package com.bibin.babu.software.developer.androidtestingindustrylevel.shopping.domain

interface ShoppingCartCache {
    fun saveCart(items: List<Product>)
    fun loadCart(): List<Product>
    fun clearCart()
}