package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            CalculatorAppTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    CalculatorScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {

    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Calculator App",
            fontSize = 32.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = number1,

            onValueChange = {
                number1 = it
            },

            label = {
                Text("Enter First Number")
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = number2,

            onValueChange = {
                number2 = it
            },

            label = {
                Text("Enter Second Number")
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row {

            // ADD BUTTON

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE)
                ),

                onClick = {

                    if (number1.isNotEmpty() && number2.isNotEmpty()) {

                        result =
                            (number1.toInt() + number2.toInt()).toString()

                    } else {

                        result = "Enter numbers"
                    }
                }
            ) {

                Text(
                    text = "+",
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // SUBTRACT BUTTON

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE)
                ),

                onClick = {

                    if (number1.isNotEmpty() && number2.isNotEmpty()) {

                        result =
                            (number1.toInt() - number2.toInt()).toString()

                    } else {

                        result = "Enter numbers"
                    }
                }
            ) {

                Text(
                    text = "-",
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // MULTIPLY BUTTON

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE)
                ),

                onClick = {

                    if (number1.isNotEmpty() && number2.isNotEmpty()) {

                        result =
                            (number1.toInt() * number2.toInt()).toString()

                    } else {

                        result = "Enter numbers"
                    }
                }
            ) {

                Text(
                    text = "*",
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // DIVIDE BUTTON

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE)
                ),

                onClick = {

                    if (number1.isNotEmpty() && number2.isNotEmpty()) {

                        if (number2 != "0") {

                            result =
                                (number1.toInt() / number2.toInt()).toString()

                        } else {

                            result = "Cannot divide by zero"
                        }

                    } else {

                        result = "Enter numbers"
                    }
                }
            ) {

                Text(
                    text = "/",
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // CLEAR BUTTON

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),

                onClick = {

                    number1 = ""
                    number2 = ""
                    result = ""
                }
            ) {

                Text(
                    text = "C",
                    fontSize = 22.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Result: $result",
            fontSize = 28.sp,
            color = Color.Blue
        )
    }
}