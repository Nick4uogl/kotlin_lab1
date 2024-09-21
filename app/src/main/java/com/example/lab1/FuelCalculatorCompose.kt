package com.example.lab1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun FuelCalculatorScreen() {
    var hp by remember { mutableStateOf("") }
    var cp by remember { mutableStateOf("") }
    var sp by remember { mutableStateOf("") }
    var np by remember { mutableStateOf("") }
    var op by remember { mutableStateOf("") }
    var wp by remember { mutableStateOf("") }
    var ap by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        InputField(value = hp, onValueChange = { hp = it }, label = "H, %")
        InputField(value = cp, onValueChange = { cp = it }, label = "CP, %")
        InputField(value = sp, onValueChange = { sp = it }, label = "S, %")
        InputField(value = np, onValueChange = { np = it }, label = "N, %")
        InputField(value = op, onValueChange = { op = it }, label = "O, %")
        InputField(value = wp, onValueChange = { wp = it }, label = "W, %")
        InputField(value = ap, onValueChange = { ap = it }, label = "A, %")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val calculator = FuelCompositionCalculator()
                result = calculator.calculateComposition(
                    hp.toDoubleOrNull() ?: 0.0,
                    cp.toDoubleOrNull() ?: 0.0,
                    sp.toDoubleOrNull() ?: 0.0,
                    np.toDoubleOrNull() ?: 0.0,
                    op.toDoubleOrNull() ?: 0.0,
                    wp.toDoubleOrNull() ?: 0.0,
                    ap.toDoubleOrNull() ?: 0.0
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = result)
    }
}

@Composable
fun InputField(value: String, onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}