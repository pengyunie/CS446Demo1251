package ca.uwaterloo.cs446.tiptime

import org.junit.Assert.*
import org.junit.Test
import java.text.NumberFormat

// unit tests for ViewModel
class TipTimeViewModelTest {
    private val viewModel = TipTimeViewModel()

    // naming convention: thingUnderTest_TriggerOfTest_ResultOfTest
    @Test
    fun tipTimeViewModel_ValidInputsEntered_TipAmountCalculated() {
        viewModel.updateAmountInput("42.00")
        viewModel.updateTipPercentInput("10.00")

        val expectedTip = NumberFormat.getCurrencyInstance().format(4.2)
        assertEquals(expectedTip, viewModel.uiState.value.tipStr)
    }
}