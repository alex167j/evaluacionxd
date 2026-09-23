package com.example.evaluacionxd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.evaluacionxd.ui.LibroApp
import com.example.evaluacionxd.ui.theme.EvaluacionxdTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EvaluacionxdTheme {
                LibroApp()
            }
        }
    }
}
