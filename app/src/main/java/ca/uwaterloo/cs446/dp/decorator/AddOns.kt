package ca.uwaterloo.cs446.dp.decorator

// the abstract decorator
abstract class HotBeverageDecorator(protected val component: HotBeverage) : HotBeverage {
    override fun getCost() = component.getCost()
    override fun getIngredients() = component.getIngredients()
}

// the concrete decorators
class AddMilk(component: HotBeverage) : HotBeverageDecorator(component) {
    override fun getCost() = super.getCost() + 0.50
    override fun getIngredients() = super.getIngredients() + listOf("Milk")
}

class AddSugar(component: HotBeverage) : HotBeverageDecorator(component) {
    override fun getCost() = super.getCost() + 0.25
    override fun getIngredients() = super.getIngredients() + listOf("Sugar")
}
