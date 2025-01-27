package ca.uwaterloo.cs446

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ca.uwaterloo.cs446.greeting.GreetingScreen
import ca.uwaterloo.cs446.igdemo.IGDemoScreen
import ca.uwaterloo.cs446.ui.theme.CS446Demo1251Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CS446Demo1251Theme {
                IGDemoScreen()
            }
        }
    }
}