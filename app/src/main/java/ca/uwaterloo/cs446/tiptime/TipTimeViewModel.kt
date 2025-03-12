package ca.uwaterloo.cs446.tiptime

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

data class TipTimeUiState(
    var amountStr: String = "",
    var tipPercentStr: String = "",
    var roundUp: Boolean = false,
    var tipStr: String = NumberFormat.getCurrencyInstance().format(0.0),
)

class TipTimeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TipTimeUiState())
    val uiState: StateFlow<TipTimeUiState> = _uiState.asStateFlow()

    val calculator = TipCalculator()

    fun updateAmountInput(input: String) {
        val amount = input.toDoubleOrNull()
        if (amount != null || input.isEmpty()) {
            _uiState.update { currentState ->
                currentState.copy(amountStr = input)
            }
            calculator.amount = amount ?: 0.0
            updateTip()
        }
    }

    fun updateTipPercentInput(input: String) {
        val tipPercent = input.toDoubleOrNull()
        if (tipPercent != null || input.isEmpty()) {
            _uiState.update { currentState ->
                currentState.copy(tipPercentStr = input)
            }
            calculator.tipPercent = tipPercent ?: 0.0
            updateTip()
        }
    }

    fun updateRoundUp(input: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(roundUp = input)
        }
        calculator.roundUp = input
        updateTip()
    }

    private fun updateTip() {
        _uiState.update { currentState ->
            currentState.copy(
                tipStr = NumberFormat.getCurrencyInstance().format(calculator.calculateTip())
            )
        }
    }
}