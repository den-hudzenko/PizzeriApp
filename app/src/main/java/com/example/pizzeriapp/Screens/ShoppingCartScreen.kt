package com.example.pizzerapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.pizzerapp.Navigation.ScreensEnum
import com.example.pizzeriapp.AppViewModelProvider
import com.example.pizzeriapp.Database.GoodItem
import com.example.pizzeriapp.ViewModel.DBViewModel

@Composable
fun ShoppingCartScreen(navController: NavController, viewModel: DBViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = AppViewModelProvider.Factory)) {
    viewModel.deleteDuplicate()
    val basketItems = viewModel.getAllSpendingItems().collectAsState(initial = listOf()).value

    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {


            Text(
                text = "Кошик", fontSize = 15.sp,
                color = Color.White, modifier = Modifier.padding(20.dp)
            )

            Divider(color = Color.White, thickness = 1.dp)
            if (basketItems.isNotEmpty()) {
                LazyColumn() {

                    items(basketItems) { item ->
                        BasketCard(item = item, viewModel)

                    }
                    item {
                        Column {


                            Card(
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Magenta,

                                    ),
                                modifier = Modifier.padding(10.dp)
                            ) {


                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(10.dp)
                                ) {

                                    Text(
                                        text = "Набір серветок",
                                        fontSize = 20.sp,
                                        color = Color.White
                                    )
                                    Text(
                                        text = "Вкажіть кількість осіб на скількох робите замовлення",
                                        fontSize = 14.sp,
                                        color = Color.White
                                    )

                                    Spacer(modifier = Modifier.height(15.dp))
                                    Row {
                                        Text(text = "—", color = Color.White, fontSize = 20.sp, modifier = Modifier.clickable {  })
                                        Text(text = "1", color = Color.White, fontSize = 20.sp)
                                        Text(text = "+", color = Color.White, fontSize = 20.sp, modifier = Modifier.clickable {  })
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {


                                Text(
                                    text = "Загальна вартість: ${
                                        basketItems.map { it.price * it.quantity }.sum()
                                    } ₴",
                                    color = Color.White,
                                    textAlign = TextAlign.Right,
                                    modifier = Modifier.fillMaxWidth()
                                )
                                Button(
                                    onClick = { navController.navigate(ScreensEnum.ORDER.name) },
                                    colors = ButtonDefaults.buttonColors(Color.Magenta),
                                    modifier = Modifier.padding(3.dp),

                                    ) {
                                    Text(text = "Оформити")
                                }
                            }
                        }
                    }
                }
            }
            else{
                Dialog(onDismissRequest = {}) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(16.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "close",

                                    modifier = Modifier
                                        .padding(top = 5.dp, end = 15.dp)
                                        .clickable {
                                            navController.navigate(ScreensEnum.MENU.name)
                                        },
                                )
                            }
                            Spacer(modifier = Modifier.weight(0.1f))

                            Text(text = "Тут пусто:(")
                            Spacer(modifier = Modifier.weight(0.3f))

                            Divider(color = Color.Black, thickness = 1.dp)
                            Spacer(modifier = Modifier.weight(0.3f))

                            Button(
                                onClick = { navController.navigate(ScreensEnum.MENU.name); },
                                colors = ButtonDefaults.buttonColors(Color.Magenta)
                            ) {
                                Text(
                                    text = "Головна сторінка",
                                    modifier = Modifier.padding(
                                        start = 10.dp,
                                        end = 10.dp,
                                        top = 5.dp,
                                        bottom = 5.dp
                                    )
                                )

                            }
                            Spacer(modifier = Modifier.weight(0.3f))

                        }
                    }

                }

            }
        }
    }
}

@Composable
fun BasketCard(item : GoodItem, viewModel: DBViewModel){


        Card (shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Magenta,

        ),
        modifier = Modifier.padding(10.dp)) {
        Row {
            Image(painter = painterResource(id = item.image), contentDescription = "pepsi")
            Column(modifier = Modifier.fillMaxHeight()) {

                Text(text = item.title, modifier = Modifier.padding(10.dp), color = Color.White)
                Spacer(modifier = Modifier.height(55.dp))
                Row {
                    Text(text = "—", color = Color.White, modifier = Modifier.clickable {
                        if(item.quantity > 1) {
                            viewModel.updateItem(item, -1)
                        }
                    })
                    Text(text = item.quantity.toString(), color = Color.White)
                    Text(text = "+", color = Color.White, modifier = Modifier.clickable {
                        viewModel.updateItem(item, 1)

                    })
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 10.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "close",
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .clickable {
                            item.id?.let { viewModel.delete(it) }
                        },
                    tint = Color.White

                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "${item.price * item.quantity} ₴",
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
                    color = Color.White
                )


            }
        }

    }
}