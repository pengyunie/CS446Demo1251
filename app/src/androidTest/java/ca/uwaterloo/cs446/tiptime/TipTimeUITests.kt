package ca.uwaterloo.cs446.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextReplacement
import ca.uwaterloo.cs446.ui.theme.CS446Demo1251Theme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipTimeUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            CS446Demo1251Theme {
                TipTimeScreen()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount").performTextReplacement("42")
        composeTestRule.onNodeWithText("Tip Percentage").performTextReplacement("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(8.4)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with this text was found.")

    }
}