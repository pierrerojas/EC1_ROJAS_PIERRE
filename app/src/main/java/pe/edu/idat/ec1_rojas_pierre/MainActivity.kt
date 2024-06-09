package pe.edu.idat.ec1_rojas_pierre

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.idat.ec1_rojas_pierre.ui.theme.EC1_ROJAS_PIERRETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EC1_ROJAS_PIERRETheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Menu(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Menu(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { context.startActivity(Intent(context, SalaryActivity::class.java)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Calcular Salario")
        }
        Button(
            onClick = { context.startActivity(Intent(context, AverageActivity::class.java)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Calcular Promedio")
        }
        Button(
            onClick = { context.startActivity(Intent(context, TimeActivity::class.java)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Calcular Minutos")
        }
        Button(
            onClick = { context.startActivity(Intent(context, SumActivity::class.java)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Calcular Suma")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    EC1_ROJAS_PIERRETheme {
        Menu()
    }
}
