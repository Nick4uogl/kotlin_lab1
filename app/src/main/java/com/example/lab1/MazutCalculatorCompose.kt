package com.example.lab1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MazutCalculatorScreen() {
    var carbonG by remember { mutableStateOf("") }
    var hydrogenG by remember { mutableStateOf("") }
    var oxygenG by remember { mutableStateOf("") }
    var sulfurG by remember { mutableStateOf("") }
    var heatValueG by remember { mutableStateOf("") }
    var moistureP by remember { mutableStateOf("") }
    var ashD by remember { mutableStateOf("") }
    var vanadiumG by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        InputField(value = carbonG, onValueChange = { carbonG = it }, label = "Вуглець (C), %")
        InputField(value = hydrogenG, onValueChange = { hydrogenG = it }, label = "Водень (H), %")
        InputField(value = oxygenG, onValueChange = { oxygenG = it }, label = "Кисень (O), %")
        InputField(value = sulfurG, onValueChange = { sulfurG = it }, label = "Сірка (S), %")
        InputField(value = heatValueG, onValueChange = { heatValueG = it }, label = "Нижча теплота згоряння МДж/кг")
        InputField(value = moistureP, onValueChange = { moistureP = it }, label = "Вологість, %")
        InputField(value = ashD, onValueChange = { ashD = it }, label = "Зольність, %")
        InputField(value = vanadiumG, onValueChange = { vanadiumG = it }, label = "Вміст ванадію (V), мг/кг")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val calculator = MazutCalculator()
                result = calculator.calculateMazutComposition(
                    carbonG.toDoubleOrNull() ?: 0.0,
                    hydrogenG.toDoubleOrNull() ?: 0.0,
                    oxygenG.toDoubleOrNull() ?: 0.0,
                    sulfurG.toDoubleOrNull() ?: 0.0,
                    heatValueG.toDoubleOrNull() ?: 0.0,
                    moistureP.toDoubleOrNull() ?: 0.0,
                    ashD.toDoubleOrNull() ?: 0.0,
                    vanadiumG.toDoubleOrNull() ?: 0.0
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Розрахувати")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = result)
    }
}