package ca.uwaterloo.cs446.tiptime

import kotlin.math.ceil

class TipCalculator(
    var amount: Double = 0.0,
    var tipPercent: Double = 0.0,
    var roundUp: Boolean = false,
) {
    fun calculateTip(): Double {
        var tip = tipPercent / 100 * amount
        if (roundUp) {
            tip = ceil(tip)
        }
        return tip
    }
}