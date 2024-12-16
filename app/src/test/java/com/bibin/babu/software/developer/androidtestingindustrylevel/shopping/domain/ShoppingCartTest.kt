package com.bibin.babu.software.developer.androidtestingindustrylevel.shopping.domain

import androidx.core.app.RemoteInput.Source
import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class ShoppingCartTest {
    private lateinit var cart: ShoppingCart

    @BeforeEach
    fun setUp() {
        cart = ShoppingCart()
    }

    @AfterEach
    fun tearDown() {

    }

    @Test
    fun `Add multiple products, total price sum is correct`() {
        // GIVEN
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )
        cart.addProduct(product, 4)

        // ACTION
        val priceSum = cart.getTotalCost()

        // ASSERTION
        assertThat(priceSum).isEqualTo(20.0)
    }

    @RepeatedTest(100)
    fun `Add product with negative quantity, throws Exception`() {
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )

        assertFailure {
            cart.addProduct(product, -5)
        }
    }


    @ParameterizedTest
    // @ValueSource(ints = [0,1,2,4,5,6])
    @CsvSource(
        "3,15.0",
        "0,0.0",
        "6,30.0",
        "20,100.0",
        ///dsvguds
    )
    fun `Add multiple products, total price sum is correct ParameterizedTest`(
        quantity: Int,
        expectedPriceSum: Double
    ) {
        // GIVEN
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )
        cart.addProduct(product, quantity)

        // ACTION
        val priceSum = cart.getTotalCost()

        // ASSERTION
        // assertThat(priceSum).isEqualTo(quantity * 5.0)
        assertThat(priceSum).isEqualTo(expectedPriceSum)
    }

    @Test
    fun `isValid product return invalid for invalid product`() {
        val product = Product(
            id = 200,
            name = "Ice cream",
            price = 5.0
        )
        cart.addProduct(product, 5)
        val toPriseSum = cart.getTotalCost()
        assertThat(toPriseSum).isEqualTo(0)


    }
}