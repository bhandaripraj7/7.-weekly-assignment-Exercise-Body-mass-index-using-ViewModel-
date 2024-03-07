package com.example.bmiviewmodelassignment

import BmiViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiCalculatorScreen()
        }
    }
}
@Composable
fun BmiCalculatorScreen(bmiViewModel: BmiViewModel = viewModel()) {
    val height by bmiViewModel.height
    val weight by bmiViewModel.weight
    val bmi by bmiViewModel.bmi

    Column(modifier = Modifier.padding(16.dp)) {
        // Use a Material 3 typography style, e.g., TitleLarge
        Text(text = "Body mass index", style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(
            value = height,
            onValueChange = { bmiViewModel.height.value = it },
            label = { Text("Height") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = weight,
            onValueChange = { bmiViewModel.weight.value = it },
            label = { Text("Weight") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = { bmiViewModel.calculateBmi() }) {
            Text("Calculate BMI")
        }
        if (bmi.isNotEmpty()) {
            Text("Body mass index is $bmi")
        }
    }
}