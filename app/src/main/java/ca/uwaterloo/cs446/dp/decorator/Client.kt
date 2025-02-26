package ca.uwaterloo.cs446.dp.decorator


fun main() {
    val coffee: HotBeverage = BlackCoffee()
    val coffeeWMilk: HotBeverage = AddMilk(coffee)
    val coffeeWMilkSugar: HotBeverage = AddSugar(coffeeWMilk)

    val tea: HotBeverage = BlackTea()
    val teaWSugar: HotBeverage = AddSugar(tea)
    val teaWSugarMilk: HotBeverage = AddMilk(teaWSugar)

    val beverages: MutableList<HotBeverage> = ArrayList()
    beverages.add(coffee)
    beverages.add(coffeeWMilkSugar)
    beverages.add(tea)
    beverages.add(teaWSugarMilk)

    for (beverage in beverages) {
        println(
            "Beverage ${
                beverage.getIngredients().joinToString()
            }: \$" + "%.2f".format(beverage.getCost())
        )
    }
}