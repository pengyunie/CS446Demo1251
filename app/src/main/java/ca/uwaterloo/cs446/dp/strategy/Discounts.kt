package ca.uwaterloo.cs446.dp.strategy

import java.lang.Math.random
import kotlin.math.max

// the strategy interface
interface Discount {
    /** Given full price, computes the price after applying the discount. */
    fun compute(fullPrice: Double): Double
}


// the concrete strategies

class NoDiscount : Discount {
    override fun compute(fullPrice: Double) = fullPrice
}

class FlatRateDiscount(private val amount: Double) : Discount {
    /** Subtracts a fixed amount from the full price. */
    override fun compute(fullPrice: Double): Double = max(fullPrice - amount, 0.0)
}

class PercentDiscount(private val percent: Double) : Discount {
    /** Reduces the full price by a percentage. */
    override fun compute(fullPrice: Double): Double = fullPrice * (1 - percent / 100)
}

class RandomDiscount(private val minPercent: Double, private val maxPercent: Double) : Discount {
    /** Reduces the full price by a random percentage within a range. */
    override fun compute(fullPrice: Double): Double {
        val percent: Double = minPercent + random() * (maxPercent - minPercent)
        return fullPrice * (1 - percent / 100.0)
    }
}
