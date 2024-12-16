package com.bibin.babu.software.developer.androidtestingindustrylevel.shopping.domain

class ShoppingCart {
    private val items = mutableListOf<Product>()
    private val validProductIds = listOf(1, 2, 3, 4, 5)

    fun addProduct(product: Product, quantity: Int) {
        if(quantity < 0) {
            throw IllegalArgumentException("Quantity can't be negative")
        }
        if(isValidProduct(product)) {
            repeat(quantity) {
                items.add(product)
            }
        }
    }


    private fun isValidProduct(product: Product): Boolean {
        return product.price<0.0 && product.id in validProductIds

    }

    fun getTotalCost(): Double {
        return items.sumOf { it.price }
    }
}