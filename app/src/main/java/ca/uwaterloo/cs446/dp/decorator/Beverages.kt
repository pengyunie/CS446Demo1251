package ca.uwaterloo.cs446.dp.decorator

// the component interface
interface HotBeverage {
    fun getCost(): Double
    fun getIngredients(): List<String>
}

// the concrete components
class BlackCoffee : HotBeverage {
    override fun getCost() = 2.00
    override fun getIngredients() = listOf("Coffee")
}

class BlackTea : HotBeverage {
    override fun getCost() = 1.50
    override fun getIngredients() = listOf("Tea")
}
