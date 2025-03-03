package ca.uwaterloo.cs446.dp.strategy

fun main() {
    val fullPrice: Double = 99.8

    var discountStrategy: Discount = NoDiscount()

    println("Select discount strategy:")
    println("  [1] flat rate -10")
    println("  [2] percentage -8%")
    println("  [3] I'm feeling lucky")
    print("Your selection: ")
    when (readlnOrNull()) {
        "1" -> discountStrategy = FlatRateDiscount(10.0)
        "2" -> discountStrategy = PercentDiscount(8.0)
        "3" -> discountStrategy = RandomDiscount(5.0, 15.0)
        else -> println("Wrong input, no discount")
    }

    println("Your discounted total is \$${discountStrategy.compute(fullPrice)}")
}