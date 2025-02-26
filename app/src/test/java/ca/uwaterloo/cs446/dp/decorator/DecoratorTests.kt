package ca.uwaterloo.cs446.dp.decorator

import org.junit.Test
import org.junit.Assert.*

class DecoratorTests {
    @Test
    fun testBlackCoffee() {
        val blackCoffee: HotBeverage = BlackCoffee()
        assertEquals(2.0, blackCoffee.getCost(), 0.001)
        assertEquals(listOf("Coffee"), blackCoffee.getIngredients())
    }

    @Test
    fun testBlackCoffeeWMilk() {
        val beverage: HotBeverage = AddMilk(BlackCoffee())
        assertEquals(2.5, beverage.getCost(), 0.001)
        assertEquals(listOf("Coffee", "Milk"), beverage.getIngredients())
    }

    @Test
    fun testBlackCoffeeWSugar() {
        val beverage: HotBeverage = AddSugar(BlackCoffee())
        assertEquals(2.25, beverage.getCost(), 0.001)
        assertEquals(listOf("Coffee", "Sugar"), beverage.getIngredients())
    }

    @Test
    fun testBlackCoffeeWMilkSugar() {
        val beverage: HotBeverage = AddSugar(AddMilk(BlackCoffee()))
        assertEquals(2.75, beverage.getCost(), 0.001)
        assertEquals(listOf("Coffee", "Milk", "Sugar"), beverage.getIngredients())
    }

    @Test
    fun testBlackTea() {
        val blackTea: HotBeverage = BlackTea()
        assertEquals(1.5, blackTea.getCost(), 0.001)
        assertEquals(listOf("Tea"), blackTea.getIngredients())
    }

    @Test
    fun testBlackTeaWMilk() {
        val beverage: HotBeverage = AddMilk(BlackTea())
        assertEquals(2.0, beverage.getCost(), 0.001)
        assertEquals(listOf("Tea", "Milk"), beverage.getIngredients())
    }

    @Test
    fun testBlackTeaWSugar() {
        val beverage: HotBeverage = AddSugar(BlackTea())
        assertEquals(1.75, beverage.getCost(), 0.001)
        assertEquals(listOf("Tea", "Sugar"), beverage.getIngredients())
    }

    @Test
    fun testBlackTeaWMilkSugar() {
        val beverage: HotBeverage = AddSugar(AddMilk(BlackTea()))
        assertEquals(2.25, beverage.getCost(), 0.001)
        assertEquals(listOf("Tea", "Milk", "Sugar"), beverage.getIngredients())
    }
}