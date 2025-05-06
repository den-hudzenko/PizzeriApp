package com.example.pizzerapp.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class PaymentMethod {
    CASH,
    CARD
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(){
    var paymentMethod by remember { mutableStateOf(PaymentMethod.CASH) }
    var amount by remember { mutableStateOf(0) }
    var isChangeNeeded by remember { mutableStateOf(false) }
    var city by remember { mutableStateOf("") }
    var street by remember { mutableStateOf("") }
    var buildingNumber by remember { mutableStateOf("") }
    var apartmentNumber by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }
    val isDataValid = fullName.isNotBlank() && phoneNumber.isNotBlank() &&
            city.isNotBlank() && street.isNotBlank() && buildingNumber.isNotBlank() &&
            apartmentNumber.isNotBlank()

    fun onOrderButtonClick() {
        if (isDataValid) {
        } else {
            showDialog = true
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        item {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFA000AC)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Особисті дані", color = Color.White, fontSize = 18.sp)
                    TextField(
                        value = fullName,
                        onValueChange = { fullName = it },
                        label = { Text("Прізвище Ім'я") },
                        textStyle = TextStyle(color = Color.Black),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        label = { Text("Номер телефону") },
                        textStyle = TextStyle(color = Color.Black),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()

                    )
                }
            }
        }
        item {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFA000AC)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text("Інформація про доставку", color = Color.White, fontSize = 18.sp)
                    TextField(
                        value = city,
                        onValueChange = { city = it },
                        label = { Text("Місто") },
                        textStyle = TextStyle(color = Color.Black),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        value = street,
                        onValueChange = { street = it },
                        label = { Text("Вулиця") },
                        textStyle = TextStyle(color = Color.Black),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        TextField(
                            value = buildingNumber,
                            onValueChange = { buildingNumber = it },
                            label = { Text("Номер будинку",  color = Color.Black, style = TextStyle(fontSize = 14.sp)) },
                            textStyle = TextStyle(color = Color.Black),
                            modifier = Modifier.weight(1f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                                focusedLabelColor = Color.White,
                                unfocusedLabelColor = Color.White
                            )
                        )
                        TextField(
                            value = apartmentNumber,
                            onValueChange = { apartmentNumber = it },
                            textStyle = TextStyle(color = Color.Black),
                            label = { Text("Номер квартири",  color = Color.Black, style = TextStyle(fontSize = 14.sp))},
                            modifier = Modifier.weight(1f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                                focusedLabelColor = Color.White,
                                unfocusedLabelColor = Color.White
                            )
                        )
                    }
                }
            }
        }
        item {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFA000AC)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Інформація про оплату", color = Color.White, fontSize = 18.sp)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text("Спосіб оплати:", color = Color.White, fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { paymentMethod = PaymentMethod.CASH },
                            colors = ButtonDefaults.buttonColors(if (paymentMethod == PaymentMethod.CASH) Color.Magenta else Color.Gray),
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text("Готівка", fontSize = 14.sp)
                        }
                        Button(
                            onClick = { paymentMethod = PaymentMethod.CARD },
                            colors = ButtonDefaults.buttonColors(if (paymentMethod == PaymentMethod.CARD) Color.Magenta else Color.Gray),
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text("Карта", fontSize = 14.sp)
                        }
                    }
                    if (paymentMethod == PaymentMethod.CASH) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextField(
                                value = amount.toString(),
                                onValueChange = { amount = it.toIntOrNull() ?: 0 },
                                label = { Text("Сума") },
                                textStyle = TextStyle(color = Color.Black),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    containerColor = Color.White
                                ),
                                modifier = Modifier.weight(1.5f)
                            )
                            Text(
                                "Без решти",
                                color = Color.White,
                                modifier = Modifier.weight(0.5f),
                                textAlign = TextAlign.Center
                            )
                            Checkbox(
                                checked = isChangeNeeded,
                                onCheckedChange = { isChangeNeeded = it },
                                colors = CheckboxDefaults.colors(checkedColor = Color.Magenta),
                                modifier = Modifier.weight(0.5f)
                            )
                        }

                    }
                }
            }
        }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = { onOrderButtonClick()},
                        colors = ButtonDefaults.buttonColors(Color(0xFFA000AC)),
                        modifier = Modifier.padding(8.dp),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text("Замовити", fontSize = 16.sp)
                    }
                }
            }

    }
    DataValidationAlert(showDialog) {
        showDialog = false
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewBottom(){
    OrderScreen()
}

@Composable
fun DataValidationAlert(
    showDialog: Boolean,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text("Помилка!") },
            text = { Text("Данні введено неправильно. Спробуйте ще раз!") },
            confirmButton = {
                Button(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(Color(0xFFA000AC)),
                    modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp)
                ) {
                    Text("OK")
                }
            }
        )
    }
}

