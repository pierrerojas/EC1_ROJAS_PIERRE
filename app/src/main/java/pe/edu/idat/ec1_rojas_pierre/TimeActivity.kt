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

class TimeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EC1_ROJAS_PIERRETheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TimeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TimeScreen(modifier: Modifier = Modifier) {
    var seconds by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = seconds,
            onValueChange = { seconds = it },
            label = { Text("Segundos") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            val secondsInt = seconds.toIntOrNull()
            if (secondsInt != null) {
                val minutes = secondsInt / 60
                result = "Minutos: $minutes"
            } else {
                result = "Por favor, ingrese un número válido."
            }
        }) {
            Text("Calcular Minutos")
        }
        Text(text = result, fontSize = 18.sp)
        Button(onClick = { (modifier as? ComponentActivity)?.finish() }) {
            Text("Volver")
        }
    }
}
