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

class AverageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EC1_ROJAS_PIERRETheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AverageScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AverageScreen(modifier: Modifier = Modifier) {
    var grade1 by remember { mutableStateOf("") }
    var grade2 by remember { mutableStateOf("") }
    var grade3 by remember { mutableStateOf("") }
    var grade4 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = grade1,
            onValueChange = { grade1 = it },
            label = { Text("Nota 1") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = grade2,
            onValueChange = { grade2 = it },
            label = { Text("Nota 2") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = grade3,
            onValueChange = { grade3 = it },
            label = { Text("Nota 3") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = grade4,
            onValueChange = { grade4 = it },
            label = { Text("Nota 4") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            val grades = listOfNotNull(
                grade1.toDoubleOrNull(),
                grade2.toDoubleOrNull(),
                grade3.toDoubleOrNull(),
                grade4.toDoubleOrNull()
            ).sortedDescending()

            if (grades.size == 4) {
                val average = grades.take(3).average()
                val lowestGrade = grades.last()
                result = "Nota eliminada: $lowestGrade\nPromedio: $average"
            } else {
                result = "Por favor, ingrese todas las notas."
            }
        }) {
            Text("Calcular Promedio")
        }
        Text(text = result, fontSize = 18.sp)
        Button(onClick = { (modifier as? ComponentActivity)?.finish() }) {
            Text("Volver")
        }
    }
}
