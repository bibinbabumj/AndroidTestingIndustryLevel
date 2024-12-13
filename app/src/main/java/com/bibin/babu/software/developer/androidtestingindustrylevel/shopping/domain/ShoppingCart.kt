package com.bibin.babu.software.developer.androidtestingindustrylevel.shopping.domain

class ShoppingCart {
    private val items = mutableListOf<Product>()

    fun addProduct(product: Product, quantity: Int) {
        if(quantity < 0) {
            throw IllegalArgumentException("Quantity can't be negative")
        }
        repeat(quantity) {
            items.add(product)
        }
    }

    fun getTotalCost(): Double {
        return items.sumOf { it.price }
    }
}