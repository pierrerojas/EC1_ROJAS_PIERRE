package pe.edu.idat.ec1_rojas_pierre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.idat.ec1_rojas_pierre.ui.theme.EC1_ROJAS_PIERRETheme

class SumActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EC1_ROJAS_PIERRETheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SumScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SumScreen(modifier: Modifier = Modifier) {
    var limit by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = limit,
            onValueChange = { limit = it },
            label = { Text("Número límite") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            val limitInt = limit.toIntOrNull()
            if (limitInt != null) {
                val sum = (1..limitInt).sum()
                result = "Suma: $sum"
            } else {
                result = "Por favor, ingrese un número válido."
            }
        }) {
            Text("Calcular Suma")
        }
        Text(text = result, fontSize = 18.sp)
        Button(onClick = { (modifier as? ComponentActivity)?.finish() }) {
            Text("Volver")
        }
    }
}
