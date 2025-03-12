package ca.uwaterloo.cs446.tiptime

import org.junit.Assert.*
import org.junit.Test

// unit tests for Model / business logic
class TipCalculatorTest {

    // naming convention: testXXX()
    //   or more complicated: testXXX_withYYY_whenZZZ()
    @Test
    fun testCalculateTip() {
        val calculator = TipCalculator()
        calculator.amount = 42.0
        calculator.tipPercent = 10.0

        val tip = calculator.calculateTip()

        assertEquals(4.2, tip, 1e-6)
    }

    // TODO: add a test case testCalculateTip_withRoundUp()
}